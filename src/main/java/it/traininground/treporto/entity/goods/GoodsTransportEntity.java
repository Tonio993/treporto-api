package it.traininground.treporto.entity.goods;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.invoice.InvoiceSectionEntity;
import it.traininground.treporto.enums.TransportType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "GOODS_TRANSPORT")
public class GoodsTransportEntity extends BaseEntity {

    @ManyToOne
    private InvoiceSectionEntity invoiceSection;

    @Column
    private TransportType type;

    @ManyToOne
    @JoinColumn(name = "id_goods")
    private GoodsEntity goods;

    @Column
    private BigDecimal amount;

}
