package it.traininground.treporto.controller;

import it.traininground.treporto.controller.common.CommonRepositoryController;
import it.traininground.treporto.entity.form.invoice.InvoiceEntity;
import it.traininground.treporto.model.invoice.InvoiceModel;
import it.traininground.treporto.service.InvoiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice")
public class InvoiceController extends CommonRepositoryController<InvoiceModel, InvoiceEntity> {

    public InvoiceController(InvoiceService invoiceService) {
        super(invoiceService);
    }

}
