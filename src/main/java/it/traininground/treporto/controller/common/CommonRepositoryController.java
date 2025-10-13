package it.traininground.treporto.controller.common;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.model.BaseModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class CommonRepositoryController<MODEL extends BaseModel, ENTITY extends BaseEntity> {

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
        log.info("Saving object of type {}, {}", model.getClass(), model);
        MODEL result = commonRepositoryService.add(model);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).body(result);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<MODEL> update(@PathVariable("id") Long id, @RequestBody MODEL model) {
        log.info("Updating object of type {}, {}", model.getClass(), model);
        return ResponseEntity.of(commonRepositoryService.update(id, model));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boolean deleted = commonRepositoryService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
