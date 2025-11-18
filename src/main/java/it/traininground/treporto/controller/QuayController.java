package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.form.port.QuayEntity;
import it.traininground.treporto.model.port.QuayModel;
import it.traininground.treporto.service.QuayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quay")
public class QuayController extends CommonRepositoryController<QuayModel, QuayEntity> {

    public QuayController(QuayService quayService) {
        super(quayService);
    }

}
