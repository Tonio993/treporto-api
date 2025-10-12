package it.traininground.treporto.service;

import it.traininground.treporto.entity.invoice.InvoiceEntity;
import it.traininground.treporto.mapper.invoice.InvoiceMapper;
import it.traininground.treporto.model.invoice.InvoiceModel;
import it.traininground.treporto.repository.InvoiceRepository;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CommonRepositoryService commonRepositoryService;


    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CommonRepositoryService commonRepositoryService) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.commonRepositoryService = commonRepositoryService;
    }

    public List<InvoiceModel> get(Map<String, String> filter) {
        return StreamSupport.stream(commonRepositoryService.get(InvoiceEntity.class, filter).spliterator(), false).map(invoiceMapper::toModel).toList();
    }

    public void add(InvoiceModel invoice) {
        InvoiceEntity invoiceEntity = invoiceMapper.toEntity(invoice);
        invoiceRepository.save(invoiceEntity);
    }

}
