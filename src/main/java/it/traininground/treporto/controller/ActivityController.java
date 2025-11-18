package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.form.performance.ActivityEntity;
import it.traininground.treporto.model.invoice.performance.ActivityModel;
import it.traininground.treporto.service.ActivityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activity")
public class ActivityController extends CommonRepositoryController<ActivityModel, ActivityEntity> {

    public ActivityController(ActivityService activityService) {
        super(activityService);
    }

}
