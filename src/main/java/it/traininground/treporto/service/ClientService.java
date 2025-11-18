package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.registry.ClientEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ClientModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CommonRepositoryService<ClientModel, ClientEntity> {

    protected ClientService(ModelEntityMapper<ClientModel, ClientEntity> modelEntityMapper) {
        super(modelEntityMapper, ClientEntity.class);
    }

}
