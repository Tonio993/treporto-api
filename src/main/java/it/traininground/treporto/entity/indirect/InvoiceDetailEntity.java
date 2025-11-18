package it.traininground.treporto.entity.indirect;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.form.fare.FareEntity;
import it.traininground.treporto.entity.form.invoice.InvoiceEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "INVOICE_DETAIL")
public class InvoiceDetailEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "id_invoice")
    private InvoiceEntity invoice;

    @ManyToOne
    @JoinColumn(name = "id_fare")
    private FareEntity fare;

    @Column
    private BigDecimal performancePrice;


}
