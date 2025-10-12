package it.traininground.treporto.mapper.common;

import it.traininground.treporto.entity.BaseEntity;
import org.mapstruct.MapperConfig;

@MapperConfig(uses = {CommonMapping.class})
public interface ModelEntityMapper<MODEL, ENTITY extends BaseEntity> {

    MODEL toModel(ENTITY entity);

    ENTITY toEntity(MODEL model);

}
