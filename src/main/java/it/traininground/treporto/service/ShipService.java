package it.traininground.treporto.service;

import it.traininground.treporto.entity.registry.ShipEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ShipModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ShipService extends CommonRepositoryService<ShipModel, ShipEntity> {

    protected ShipService(EntityManager entityManager, ModelEntityMapper<ShipModel, ShipEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, ShipEntity.class);
    }

}
