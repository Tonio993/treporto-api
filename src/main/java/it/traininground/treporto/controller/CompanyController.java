package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.registry.CompanyEntity;
import it.traininground.treporto.model.registry.CompanyModel;
import it.traininground.treporto.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController extends CommonRepositoryController<CompanyModel, CompanyEntity> {

    public CompanyController(CompanyService companyService) {
        super(companyService);
    }

}
