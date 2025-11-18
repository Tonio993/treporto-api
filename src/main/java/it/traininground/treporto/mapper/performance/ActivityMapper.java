package it.traininground.treporto.mapper.performance;

import it.traininground.treporto.entity.form.performance.ActivityEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.performance.ActivityModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface ActivityMapper extends ModelEntityMapper<ActivityModel, ActivityEntity> {
}
