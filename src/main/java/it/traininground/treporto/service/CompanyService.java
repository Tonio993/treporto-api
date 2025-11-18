package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.registry.CompanyEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.CompanyModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends CommonRepositoryService<CompanyModel, CompanyEntity> {

    protected CompanyService(ModelEntityMapper<CompanyModel, CompanyEntity> modelEntityMapper) {
        super(modelEntityMapper, CompanyEntity.class);
    }

}
