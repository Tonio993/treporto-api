package it.traininground.treporto.mapper.common;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;

@Mapper(componentModel = "spring")
public abstract class CommonMapping {

    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseEntity> T resolveEntity(Long id, @TargetType Class<T> entityClass) {
        return id != null ? entityManager.find(entityClass, id) : null;
    }

    public Long map(BaseEntity entity) {
        return entity != null ? entity.getId() : null;
    }

}
