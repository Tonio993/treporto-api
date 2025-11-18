package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.registry.ShipEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ShipModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class ShipService extends CommonRepositoryService<ShipModel, ShipEntity> {

    protected ShipService(ModelEntityMapper<ShipModel, ShipEntity> modelEntityMapper) {
        super(modelEntityMapper, ShipEntity.class);
    }

}
