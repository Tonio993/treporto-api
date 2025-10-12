package it.traininground.treporto.service;

import it.traininground.treporto.entity.registry.CompanyEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.CompanyModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends CommonRepositoryService<CompanyModel, CompanyEntity> {

    protected CompanyService(EntityManager entityManager, ModelEntityMapper<CompanyModel, CompanyEntity> modelEntityMapper) {
        super(entityManager, modelEntityMapper, CompanyEntity.class);
    }

}
