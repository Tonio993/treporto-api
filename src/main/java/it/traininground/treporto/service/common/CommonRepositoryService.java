package it.traininground.treporto.service.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CommonRepositoryService {

    private final EntityManager entityManager;

    public CommonRepositoryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <T> List<T> get(Class<T> clazz, Map<String, String> filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.where(filter.entrySet().stream().map(entry -> getPredicate(builder, root, entry.getKey(), entry.getValue())).toArray(Predicate[]::new));
        return entityManager.createQuery(query).getResultList();
    }

    private <T> Predicate getPredicate(CriteriaBuilder builder, Path<T> path, String key, String value) {
        Pattern filterPattern = Pattern.compile("(\\w+?)(?:__(\\w+?))?");
        Matcher matcher = filterPattern.matcher(key);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Filter format " + key + " unrecognized");
        }
        String field = matcher.group(1);
        String type = matcher.group(2);

        Object compareValue = path.get(field).getJavaType().isEnum() ? Enum.valueOf((Class<Enum>) path.get(field).getJavaType(), value) : value;

        if (isEmpty(type)) {
            return builder.equal(path.get(field), compareValue);
        }

        return switch (type) {
            case "gt" -> builder.greaterThan(path.get(field), value);
            case "ge" -> builder.greaterThanOrEqualTo(path.get(field), value);
            case "lt" -> builder.lessThan(path.get(field), value);
            case "le" -> builder.lessThanOrEqualTo(path.get(field), value);
            default -> throw new IllegalArgumentException("Filter type " + type + " unrecognized");
        };

    }

}
