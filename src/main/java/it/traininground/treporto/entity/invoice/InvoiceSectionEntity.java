package it.traininground.treporto.entity.invoice;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.goods.GoodsTransportEntity;
import it.traininground.treporto.entity.performance.PerformanceEntity;
import it.traininground.treporto.enums.SectionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "INVOICE_SECTION")
public class InvoiceSectionEntity extends BaseEntity {

    @Column
    private SectionType type;

    @Column
    private LocalDate date;

    @Column
    private BigDecimal discount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_section")
    @Fetch(FetchMode.SUBSELECT)
    private List<PerformanceEntity> performanceList;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_section")
    @Fetch(FetchMode.SUBSELECT)
    private List<GoodsTransportEntity> goodsTransportList;
}
