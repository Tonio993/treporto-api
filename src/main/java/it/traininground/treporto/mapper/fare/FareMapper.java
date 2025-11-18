package it.traininground.treporto.mapper.fare;

import it.traininground.treporto.entity.form.fare.FareEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.fare.FareModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class, uses = FareThresholdMapper.class)
public interface FareMapper extends ModelEntityMapper<FareModel, FareEntity> {
}
