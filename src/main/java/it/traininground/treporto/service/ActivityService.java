package it.traininground.treporto.service;

import it.traininground.treporto.entity.performance.ActivityEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.performance.ActivityModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ActivityService extends CommonRepositoryService<ActivityModel, ActivityEntity> {

    protected ActivityService(EntityManager entityManager, ModelEntityMapper<ActivityModel, ActivityEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, ActivityEntity.class);
    }

}
