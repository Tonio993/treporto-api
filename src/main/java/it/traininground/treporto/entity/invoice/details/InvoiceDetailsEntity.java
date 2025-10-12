package it.traininground.treporto.entity.invoice.details;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.invoice.InvoiceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class InvoiceDetailsEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "id_invoice")
    private InvoiceEntity invoice;

    @Column
    private double performancePrice;



}
