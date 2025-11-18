package it.traininground.treporto.mapper.registry;

import it.traininground.treporto.entity.form.registry.CompanyEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.registry.CompanyModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface CompanyMapper extends ModelEntityMapper<CompanyModel, CompanyEntity> {
}
