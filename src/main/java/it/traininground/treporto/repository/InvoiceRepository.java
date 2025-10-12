package it.traininground.treporto.repository;

import it.traininground.treporto.entity.invoice.InvoiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
}
