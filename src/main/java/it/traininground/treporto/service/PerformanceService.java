package it.traininground.treporto.service;

import it.traininground.treporto.entity.performance.PerformanceEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.performance.PerformanceModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService extends CommonRepositoryService<PerformanceModel, PerformanceEntity> {

    protected PerformanceService(EntityManager entityManager, ModelEntityMapper<PerformanceModel, PerformanceEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, PerformanceEntity.class);
    }

}
