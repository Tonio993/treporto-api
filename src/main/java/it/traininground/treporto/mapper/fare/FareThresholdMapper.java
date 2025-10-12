package it.traininground.treporto.mapper.fare;

import it.traininground.treporto.entity.fare.FareThresholdEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.fare.FareThresholdModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface FareThresholdMapper extends ModelEntityMapper<FareThresholdModel, FareThresholdEntity> {
}
