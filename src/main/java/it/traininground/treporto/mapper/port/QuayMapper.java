package it.traininground.treporto.mapper.port;

import it.traininground.treporto.entity.port.QuayEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.port.QuayModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface QuayMapper extends ModelEntityMapper<QuayModel, QuayEntity> {
}
