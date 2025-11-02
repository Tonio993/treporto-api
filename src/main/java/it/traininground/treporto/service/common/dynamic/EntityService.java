package it.traininground.treporto.service.common.dynamic;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EntityService {

    private final EntityManager entityManager;
    private final Map<String, Class<?>> entityMap;

    @Autowired
    public EntityService(EntityManager entityManager) {
        this.entityManager = entityManager;
        entityMap = new HashMap<>();
    }

    @PostConstruct
    private void init() {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        entityMap.putAll(entities.stream()
                .collect(Collectors.toMap(
                        e -> e.getName().toUpperCase(),
                        EntityType::getJavaType
                ))
        );
    }

    public Class<?> findEntityClassByEntityName(String entityName) {
        Class<?> entityClass = entityMap.get(entityName.toUpperCase());
        if (entityClass == null) {
            throw new IllegalArgumentException("Entity name not found: " + entityName);
        }
        return entityClass;
    }

}
