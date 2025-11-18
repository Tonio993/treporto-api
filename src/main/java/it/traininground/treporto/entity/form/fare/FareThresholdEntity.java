package it.traininground.treporto.entity.form.fare;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "FARE_THRESHOLD")
public class FareThresholdEntity extends BaseEntity {

    @Column
    private Integer threshold;

    @Column
    private BigDecimal price;

}
