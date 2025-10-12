package it.traininground.treporto.entity.fare;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "FARE_THRESHOLD")
public class FareThresholdEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_fare")
    private FareEntity fare;

    @Column
    private Integer threshold;

    @Column
    private BigDecimal price;

}
