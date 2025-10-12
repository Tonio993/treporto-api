package it.traininground.treporto.mapper.goods;

import it.traininground.treporto.entity.goods.GoodsEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.goods.GoodsModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface GoodsMapper extends ModelEntityMapper<GoodsModel, GoodsEntity> {
}
