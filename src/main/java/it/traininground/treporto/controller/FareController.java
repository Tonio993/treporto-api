package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.fare.FareEntity;
import it.traininground.treporto.model.fare.FareModel;
import it.traininground.treporto.service.FareService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fare")
public class FareController extends CommonRepositoryController<FareModel, FareEntity> {

    public FareController(FareService fareService) {
        super(fareService);
    }

}
