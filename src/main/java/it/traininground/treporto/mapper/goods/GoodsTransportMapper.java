package it.traininground.treporto.mapper.goods;

import it.traininground.treporto.entity.goods.GoodsTransportEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.goods.GoodsTransportModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface GoodsTransportMapper extends ModelEntityMapper<GoodsTransportModel, GoodsTransportEntity> {
}
