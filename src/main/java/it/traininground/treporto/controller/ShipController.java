package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.registry.ShipEntity;
import it.traininground.treporto.model.registry.ShipModel;
import it.traininground.treporto.service.ShipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ship")
@Slf4j
public class ShipController extends CommonRepositoryController<ShipModel, ShipEntity> {

    public ShipController(ShipService shipService) {
        super(shipService);
    }

}
