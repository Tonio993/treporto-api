package it.traininground.treporto.controller;

import it.traininground.treporto.model.fattura.Fattura;
import it.traininground.treporto.service.FatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/fattura")
public class FatturaController {

    @Autowired
    FatturaService fatturaService;

    @GetMapping
    public List<Fattura> get() {
        return fatturaService.get();
    }

    @PostMapping
    public void add() {
        fatturaService.add();
    }
}
