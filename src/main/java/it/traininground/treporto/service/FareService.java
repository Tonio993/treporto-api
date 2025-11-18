package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.fare.FareEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.fare.FareModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class FareService extends CommonRepositoryService<FareModel, FareEntity> {

    protected FareService(ModelEntityMapper<FareModel, FareEntity> modelEntityMapper) {
        super(modelEntityMapper, FareEntity.class);
    }

}
