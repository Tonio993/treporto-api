package it.traininground.treporto.service.common.dynamic;

import it.traininground.treporto.enums.FilterOperator;
import it.traininground.treporto.model.DynamicQueryFilter;
import it.traininground.treporto.model.DynamicQueryRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DynamicQueryService {

    private final EntityManager entityManager;
    private final EntityService entityService;

    public DynamicQueryService(EntityManager entityManager, EntityService entityService) {
        this.entityManager = entityManager;
        this.entityService = entityService;
    }

    public List<Map<String, Object>> executeDynamicQuery(DynamicQueryRequest request) {

        Class<?> entityClass = entityService.findEntityClassByEntityName(request.getEntity());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
        Root<?> root = query.from(entityClass);

        Map<String, Join<?, ?>> joins = buildJoinMap(request, root);
        List<Selection<?>> selections = buildSelectionList(request, root, joins, entityClass);
        List<Predicate> predicates = buildPredicateList(request, root, joins, criteriaBuilder);

        query.multiselect(selections);
        query.where(predicates.toArray(Predicate[]::new));
        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        List<Tuple> resultTuples = typedQuery.getResultList();

        return buildResultParsing(resultTuples);
    }

    private List<Map<String, Object>> buildResultParsing(List<Tuple> resultTuples) {
        return resultTuples.stream()
                .map(tuple -> {
                    Map<String, Object> row = new LinkedHashMap<>();
                    for (TupleElement<?> element : tuple.getElements()) {
                        row.put(element.getAlias(), tuple.get(element));
                    }
                    return row;
                })
                .toList();
    }

    private List<Predicate> buildPredicateList(DynamicQueryRequest request, Root<?> root, Map<String, Join<?, ?>> joins, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (request.getFilters() != null) {
            for (DynamicQueryFilter filter : request.getFilters()) {
                Path<?> path = resolvePath(root, joins, filter.getField());
                predicates.add(createPredicate(criteriaBuilder, path, filter.getOperator(), filter.getValue()));
            }
        }
        return predicates;
    }

    private List<Selection<?>> buildSelectionList(DynamicQueryRequest request, Root<?> root, Map<String, Join<?, ?>> joins, Class<?> entityClass) {
        List<Selection<?>> selections = new ArrayList<>();
        if (request.getFields() != null && !request.getFields().isEmpty()) {
            for (Map.Entry<String, String> entry : request.getFields().entrySet()) {
                String alias = entry.getKey();
                String pathExpr = entry.getValue();
                Path<?> path = resolvePath(root, joins, pathExpr);
                selections.add(path.alias(alias));
            }
        } else {
            var entityType = entityManager.getMetamodel().entity(entityClass);
            entityType.getAttributes().forEach(attr -> {
                String fieldName = attr.getName();
                selections.add(root.get(fieldName).alias(fieldName));
            });
        }
        return selections;
    }

    private Map<String, Join<?, ?>> buildJoinMap(DynamicQueryRequest request, Root<?> root) {
        Map<String, Join<?, ?>> joins = new HashMap<>();

        if (request.getJoins() != null) {
            for (String joinField : request.getJoins()) {
                joins.put(joinField, root.join(joinField, JoinType.INNER));
            }
        }

        Set<String> neededJoins = new HashSet<>();
        if (request.getFields() != null) {
            request.getFields().values().forEach(v -> {
                if (v.contains(".")) neededJoins.add(v.split("\\.")[0]);
            });
        }
        if (request.getFilters() != null) {
            request.getFilters().forEach(f -> {
                if (f.getField().contains(".")) neededJoins.add(f.getField().split("\\.")[0]);
            });
        }

        for (String joinField : neededJoins) {
            joins.computeIfAbsent(joinField, f -> root.join(f, JoinType.LEFT));
        }
        return joins;
    }

    @SuppressWarnings("unchecked")
    private Predicate createPredicate(CriteriaBuilder cb, Path<?> path, FilterOperator operator, Object value) {
        return switch (operator) {
            case EQUALS -> cb.equal(path, value);
            case NOT_EQUALS -> cb.notEqual(path, value);
            case GREATER ->
                    cb.greaterThan((Expression<Comparable<? super Comparable<?>>>) path, (Comparable<? super Comparable<?>>) value);
            case LOWER ->
                    cb.lessThan((Expression<Comparable<? super Comparable<?>>>) path, (Comparable<? super Comparable<?>>) value);
            case GREATER_OR_EQUALS ->
                    cb.greaterThanOrEqualTo((Expression<Comparable<? super Comparable<?>>>) path, (Comparable<? super Comparable<?>>) value);
            case LOWER_OR_EQUALS ->
                    cb.lessThanOrEqualTo((Expression<Comparable<? super Comparable<?>>>) path, (Comparable<? super Comparable<?>>) value);
            case LIKE -> cb.like(path.as(String.class), "%" + value + "%");
            case IN -> createInClause(path, value);
        };
    }

    private Predicate createInClause(Expression<?> path, Object value) {
        if (value instanceof Collection<?> values) {
            return path.in(values);
        } else {
            throw new IllegalArgumentException("Valore non valido per operatore IN: " + value);
        }
    }

    private Path<?> resolvePath(Root<?> root, Map<String, Join<?, ?>> joins, String fieldPath) {
        if (fieldPath.contains(".")) {
            String[] parts = fieldPath.split("\\.");
            Join<?, ?> join = joins.get(parts[0]);
            if (join == null) throw new RuntimeException("Join non definita per: " + parts[0]);
            return join.get(parts[1]);
        }
        return root.get(fieldPath);
    }

}