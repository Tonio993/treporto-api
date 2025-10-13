package it.traininground.treporto.entity.performance;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.invoice.InvoiceSectionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "PERFORMANCE")
public class PerformanceEntity extends BaseEntity {

    @ManyToOne
    private InvoiceSectionEntity invoiceSection;

    @ManyToOne
    @JoinColumn(name = "id_activity")
    private ActivityEntity activity;

    @Column
    private Boolean missing;

    @Column
    private String title;

    @Column
    private BigDecimal price;
}
