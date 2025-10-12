package it.traininground.treporto.mapper.registry;

import it.traininground.treporto.entity.registry.ClientEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.ClientModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface ClientMapper extends ModelEntityMapper<ClientModel, ClientEntity> {
}
