package it.traininground.treporto.entity.performance;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "ACTIVITY")
public class ActivityEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private BigDecimal performanceFactor;

}
