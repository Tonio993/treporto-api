package it.traininground.treporto.service.common;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.form.fare.FareEntity;
import it.traininground.treporto.entity.form.fare.FareThresholdEntity;
import it.traininground.treporto.entity.form.invoice.InvoiceEntity;
import it.traininground.treporto.entity.indirect.InvoiceDetailEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class IndirectEntitiesService {

    private final EntityManager entityManager;

    private final Map<Class<? extends BaseEntity>, Consumer<? extends BaseEntity>> indirectEntitiesMap;

    public IndirectEntitiesService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.indirectEntitiesMap = new HashMap<>();

        registerIndirectEntity(InvoiceEntity.class, entity -> {

            Long id = (Long) this.entityManager.createNativeQuery("select id from INVOICE_DETAIL where id_invoice = :id", Long.class).setParameter("id", entity.getId()).getResultStream().findFirst().orElse(null);

            InvoiceDetailEntity invoiceDetail = new InvoiceDetailEntity();
            FareEntity fare = (FareEntity) this.entityManager.createNativeQuery("select * from FARE where date <= :date order by date desc limit 1", FareEntity.class).setParameter("date", entity.getDate()).getSingleResult();
            BigDecimal performancePrice = fare.getFareThresholdList().stream().filter(i -> i.getThreshold() < entity.getIdShip().getSize()).max(Comparator.comparing(FareThresholdEntity::getThreshold)).get().getPrice();

            invoiceDetail.setId(id);
            invoiceDetail.setInvoice(entity);
            invoiceDetail.setFare(fare);
            invoiceDetail.setPerformancePrice(performancePrice);

            entityManager.merge(invoiceDetail);
        });
    }

    public <T extends BaseEntity> void registerIndirectEntity(Class<T> clazz, Consumer<T> consumer) {
        indirectEntitiesMap.put(clazz, consumer);
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> void checkForIndirectEntities(Class<T> clazz, T entity) {
        Consumer<T> indirectEntityProcessor = (Consumer<T>) indirectEntitiesMap.get(clazz);
        if (indirectEntityProcessor != null) {
            indirectEntityProcessor.accept(entity);
        }
    }


}
