package it.traininground.treporto.service;

import it.traininground.treporto.entity.form.invoice.InvoiceEntity;
import it.traininground.treporto.mapper.invoice.InvoiceMapper;
import it.traininground.treporto.model.invoice.InvoiceModel;
import it.traininground.treporto.service.common.CommonRepositoryService;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService extends CommonRepositoryService<InvoiceModel, InvoiceEntity> {

    protected InvoiceService(EntityManager entityManager, InvoiceMapper modelEntityMapper) {
        super(modelEntityMapper, InvoiceEntity.class);
    }
}
