package it.traininground.treporto.mapper.registry;

import it.traininground.treporto.entity.form.registry.ShipEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ShipModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface ShipMapper extends ModelEntityMapper<ShipModel, ShipEntity> {
}
