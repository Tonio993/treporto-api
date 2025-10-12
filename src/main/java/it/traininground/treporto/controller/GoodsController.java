package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.goods.GoodsEntity;
import it.traininground.treporto.model.invoice.goods.GoodsModel;
import it.traininground.treporto.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController extends CommonRepositoryController<GoodsModel, GoodsEntity> {

    public GoodsController(GoodsService goodsService) {
        super(goodsService);
    }

}
