package it.traininground.treporto.controller;

import it.traininground.treporto.model.invoice.InvoiceModel;
import it.traininground.treporto.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("invoice")
@Slf4j
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<InvoiceModel> get(@RequestParam Map<String, String> filter) {
        return invoiceService.get(filter);
    }

    @PostMapping
    public void add(@RequestBody InvoiceModel invoice) {
        log.info("Saving invoice: {}", invoice);
        invoiceService.add(invoice);
    }
}
