package it.traininground.treporto.service.common;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.BaseModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public abstract class CommonRepositoryService<MODEL extends BaseModel, ENTITY extends BaseEntity> {

    private final EntityManager entityManager;
    private final ModelEntityMapper<MODEL, ENTITY> modelEntityMapper;
    private final Class<ENTITY> entityClazz;

    protected CommonRepositoryService(EntityManager entityManager, ModelEntityMapper<MODEL, ENTITY> modelEntityMapper, Class<ENTITY> entityClazz) {
        this.entityManager = entityManager;
        this.modelEntityMapper = modelEntityMapper;
        this.entityClazz = entityClazz;
    }

    public Optional<MODEL> get(Long id) {
        return Optional.ofNullable(entityManager.find(entityClazz, id)).map(modelEntityMapper::toModel);
    }

    public List<MODEL> get(Map<String, String> filter) {
        return StreamSupport.stream(getEntity(filter).spliterator(), false).map(modelEntityMapper::toModel).toList();
    }

    private List<ENTITY> getEntity(Map<String, String> filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ENTITY> query = builder.createQuery(entityClazz);
        Root<ENTITY> root = query.from(entityClazz);
        query.where(filter.entrySet().stream().map(entry -> getPredicate(builder, root, entry.getKey(), entry.getValue())).toArray(Predicate[]::new));
        return entityManager.createQuery(query).getResultList();
    }

    private Predicate getPredicate(CriteriaBuilder builder, Path<ENTITY> path, String key, String value) {
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

    @Transactional
    public MODEL add(MODEL model) {
        ENTITY entity = modelEntityMapper.toEntity(model);
        entity.setId(null);
        entityManager.persist(entity);
        return modelEntityMapper.toModel(entity);
    }

    @Transactional
    public Optional<MODEL> update(Long id, MODEL newModel) {
        return get(id).map(currModel -> {
            ENTITY newEntity = modelEntityMapper.toEntity(newModel);
            newEntity.setId(id);
            return modelEntityMapper.toModel(entityManager.merge(newEntity));
        });
    }

    @Transactional
    public boolean delete(Long id) {
        ENTITY entity = entityManager.find(entityClazz, id);
        if (entity != null) {
            entityManager.remove(entity);
            return true;
        }
        return false;
    }

}
