package it.traininground.treporto.controller.common;

import it.traininground.treporto.model.DynamicQueryRequest;
import it.traininground.treporto.service.common.DynamicQueryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("query")
public class DynamicQueryController {

    private final DynamicQueryService service;

    public DynamicQueryController(DynamicQueryService service) {
        this.service = service;
    }

    @PostMapping
    public List<Map<String, Object>> executeQuery(@RequestBody DynamicQueryRequest request) {
        return service.executeDynamicQuery(request);
    }
}