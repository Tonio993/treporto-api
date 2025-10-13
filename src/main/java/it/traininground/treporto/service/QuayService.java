package it.traininground.treporto.service;

import it.traininground.treporto.entity.port.QuayEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.port.QuayModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class QuayService extends CommonRepositoryService<QuayModel, QuayEntity> {

    protected QuayService(EntityManager entityManager, ModelEntityMapper<QuayModel, QuayEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, QuayEntity.class);
    }

}
