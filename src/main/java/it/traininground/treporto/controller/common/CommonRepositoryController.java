package it.traininground.treporto.controller.common;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.service.common.CommonRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class CommonRepositoryController<MODEL, ENTITY extends BaseEntity> {

    private final CommonRepositoryService<MODEL, ENTITY> commonRepositoryService;

    public CommonRepositoryController(CommonRepositoryService<MODEL, ENTITY> commonRepositoryService) {
        this.commonRepositoryService = commonRepositoryService;
    }

    @GetMapping
    public List<MODEL> get(@RequestParam Map<String, String> filter) {
        return commonRepositoryService.get(filter);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<MODEL> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(commonRepositoryService.get(id));
    }

    @PostMapping
    public ResponseEntity<MODEL> add(@RequestBody MODEL model) {
        log.info("Saving object of type {}, {}", model, model);
        Long id = commonRepositoryService.add(model);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

}
