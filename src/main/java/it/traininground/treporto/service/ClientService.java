package it.traininground.treporto.service;

import it.traininground.treporto.entity.registry.ClientEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ClientModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CommonRepositoryService<ClientModel, ClientEntity> {

    protected ClientService(EntityManager entityManager, ModelEntityMapper<ClientModel, ClientEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, ClientEntity.class);
    }

}
