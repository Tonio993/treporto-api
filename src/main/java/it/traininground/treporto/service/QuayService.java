package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.port.QuayEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.port.QuayModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class QuayService extends CommonRepositoryService<QuayModel, QuayEntity> {

    protected QuayService(ModelEntityMapper<QuayModel, QuayEntity> modelEntityMapper) {
        super(modelEntityMapper, QuayEntity.class);
    }

}
