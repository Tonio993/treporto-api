package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.goods.GoodsEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.goods.GoodsModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends CommonRepositoryService<GoodsModel, GoodsEntity> {

    protected GoodsService(ModelEntityMapper<GoodsModel, GoodsEntity> modelEntityMapper) {
        super(modelEntityMapper, GoodsEntity.class);
    }

}
