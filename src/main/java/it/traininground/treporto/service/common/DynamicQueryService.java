package it.traininground.treporto.service.common;

import it.traininground.treporto.enums.AggregationType;
import it.traininground.treporto.model.DynamicQueryFilter;
import it.traininground.treporto.model.DynamicQueryRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> executeDynamicQuery(DynamicQueryRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Class<?> entityClass = findEntityClassByEntityName(request.getEntity());
        Root<?> root = cq.from(entityClass);

        Map<String, Join<?, ?>> joins = new HashMap<>();

        // 1️⃣ Creazione join dinamici
        if (request.getJoins() != null) {
            for (Map.Entry<String, String> entry : request.getJoins().entrySet()) {
                String relation = entry.getKey();
                JoinType joinType = switch (entry.getValue().toUpperCase()) {
                    case "INNER" -> JoinType.INNER;
                    case "RIGHT" -> JoinType.RIGHT;
                    default -> JoinType.LEFT;
                };
                joins.put(relation, root.join(relation, joinType));
            }
        }

        // 2️⃣ Selezioni dinamiche
        List<Selection<?>> selections = new ArrayList<>();

        if (request.getFields() != null) {
            for (String field : request.getFields()) {
                Path<?> path = resolvePath(root, joins, field);
                selections.add(path.alias(field.replace('.', '_')));
            }
        }

        if (request.getAggregations() != null) {
            for (Map.Entry<String, AggregationType> entry : request.getAggregations().entrySet()) {
                String field = entry.getKey();
                AggregationType agg = entry.getValue();
                Expression<?> expr = resolvePath(root, joins, field);

                switch (agg) {
                    case SUM -> selections.add(cb.sum((Expression<Number>) expr).alias("sum_" + field));
                    case AVG -> selections.add(cb.avg((Expression<Number>) expr).alias("avg_" + field));
                    case MAX -> selections.add(cb.max((Expression<Number>) expr).alias("max_" + field));
                    case MIN -> selections.add(cb.min((Expression<Number>) expr).alias("min_" + field));
                    case COUNT -> selections.add(cb.count(expr).alias("count_" + field));
                }
            }
        }

        cq.multiselect(selections);

        // 3️⃣ Filtri
        List<Predicate> predicates = new ArrayList<>();
        if (request.getFilters() != null) {
            for (DynamicQueryFilter filter : request.getFilters()) {
                Expression<?> path = resolvePath(root, joins, filter.getField());
                Object value = filter.getValue();

                switch (filter.getOperator()) {
                    case EQUALS -> predicates.add(cb.equal(path, value));
                    case NOT_EQUALS -> predicates.add(cb.notEqual(path, value));
                    case GREATER -> predicates.add(cb.greaterThan((Expression<Comparable>) path, (Comparable) value));
                    case LOWER -> predicates.add(cb.lessThan((Expression<Comparable>) path, (Comparable) value));
                    case GREATER_OR_EQUALS ->
                            predicates.add(cb.greaterThanOrEqualTo((Expression<Comparable>) path, (Comparable) value));
                    case LOWER_OR_EQUALS ->
                            predicates.add(cb.lessThanOrEqualTo((Expression<Comparable>) path, (Comparable) value));
                    case LIKE -> predicates.add(cb.like(path.as(String.class), "%" + value + "%"));
                    case IN -> predicates.add(createInClause(path, value));
                }
            }
            cq.where(predicates.toArray(new Predicate[0]));
        }

        // 4️⃣ Group By
        if (request.getGroupBy() != null) {
            List<Expression<?>> groupByList = new ArrayList<>();
            for (String field : request.getGroupBy()) {
                groupByList.add(resolvePath(root, joins, field));
            }
            cq.groupBy(groupByList);
        }

        // 5️⃣ Esegui query
        List<Tuple> results = entityManager.createQuery(cq).getResultList();

        // 6️⃣ Conversione
        List<Map<String, Object>> response = new ArrayList<>();
        for (Tuple tuple : results) {
            Map<String, Object> row = new LinkedHashMap<>();
            for (TupleElement<?> el : tuple.getElements()) {
                row.put(el.getAlias(), tuple.get(el));
            }
            response.add(row);
        }

        return response;
    }

    private Predicate createInClause(Expression<?> path, Object value) {
        if (value instanceof Collection<?> values) {
            return path.in(values);
        } else {
            throw new IllegalArgumentException("Valore non valido per operatore IN: " + value);
        }
    }

    // Metodo helper per risolvere percorsi con dot notation (es. "customer.name")
    private Path<?> resolvePath(Root<?> root, Map<String, Join<?, ?>> joins, String fieldPath) {
        if (fieldPath.contains(".")) {
            String[] parts = fieldPath.split("\\.");
            Join<?, ?> join = joins.get(parts[0]);
            if (join == null) throw new RuntimeException("Join non definita per: " + parts[0]);
            return join.get(parts[1]);
        }
        return root.get(fieldPath);
    }

    public Class<?> findEntityClassByEntityName(String entityName) {
        Metamodel metamodel = entityManager.getMetamodel();

        for (EntityType<?> entityType : metamodel.getEntities()) {
            if (entityName.equalsIgnoreCase(entityType.getName())) {
                return entityType.getJavaType();
            }
        }

        throw new IllegalArgumentException("Entity name not found: " + entityName);
    }
}