package it.traininground.treporto.mapper.performance;

import it.traininground.treporto.entity.form.performance.PerformanceEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.performance.PerformanceModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface PerformanceMapper extends ModelEntityMapper<PerformanceModel, PerformanceEntity> {
}
