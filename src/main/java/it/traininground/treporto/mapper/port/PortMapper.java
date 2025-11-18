package it.traininground.treporto.mapper.port;

import it.traininground.treporto.entity.form.port.PortEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.port.PortModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface PortMapper extends ModelEntityMapper<PortModel, PortEntity> {
}
