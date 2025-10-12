package it.traininground.treporto.controller;

import it.traininground.treporto.model.registry.ShipModel;
import it.traininground.treporto.service.ShipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ship")
@Slf4j
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public List<ShipModel> get(@RequestParam Map<String, String> filter) {
        return shipService.get(filter);
    }

    @PostMapping
    public void add(@RequestBody ShipModel ship) {
        log.info("Saving ship: {}", ship);
        shipService.add(ship);
    }
}
