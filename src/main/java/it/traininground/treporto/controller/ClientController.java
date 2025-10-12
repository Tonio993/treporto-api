package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.registry.ClientEntity;
import it.traininground.treporto.model.registry.ClientModel;
import it.traininground.treporto.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController extends CommonRepositoryController<ClientModel, ClientEntity> {

    public ClientController(ClientService clientService) {
        super(clientService);
    }

}
