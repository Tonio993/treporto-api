package it.traininground.treporto.service;

import it.traininground.treporto.model.fattura.Fattura;
import it.traininground.treporto.repository.FatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FatturaService {

    @Autowired
    FatturaRepository repository;

    public List<Fattura> get() {
        List<Fattura> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    public void add() {
        Fattura fattura = new Fattura();
        repository.save(fattura);
    }

}
