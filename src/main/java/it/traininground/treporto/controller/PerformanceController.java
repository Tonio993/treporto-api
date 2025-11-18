package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.form.performance.PerformanceEntity;
import it.traininground.treporto.model.invoice.performance.PerformanceModel;
import it.traininground.treporto.service.PerformanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("performance")
public class PerformanceController extends CommonRepositoryController<PerformanceModel, PerformanceEntity> {

    public PerformanceController(PerformanceService performanceService) {
        super(performanceService);
    }

}
