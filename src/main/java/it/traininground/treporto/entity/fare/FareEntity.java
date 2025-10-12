package it.traininground.treporto.entity.fare;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.enums.ShipType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "FARE")
public class FareEntity extends BaseEntity {

    @Column
    private LocalDate date;

    @Column
    private ShipType shipType;

    @OneToMany(mappedBy = "fare")
    private List<FareThresholdEntity> fareThresholdList;

    @Column
    private Integer extraThreshold;

    @Column
    private BigDecimal extraPrice;

}
