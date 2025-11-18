package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.port.PortEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.port.PortModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class PortService extends CommonRepositoryService<PortModel, PortEntity> {

    protected PortService(ModelEntityMapper<PortModel, PortEntity> modelEntityMapper) {
        super(modelEntityMapper, PortEntity.class);
    }

}
