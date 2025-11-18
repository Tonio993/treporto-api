package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.form.port.PortEntity;
import it.traininground.treporto.model.port.PortModel;
import it.traininground.treporto.service.PortService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("port")
public class PortController extends CommonRepositoryController<PortModel, PortEntity> {

    public PortController(PortService portService) {
        super(portService);
    }

}
