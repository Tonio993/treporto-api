package it.traininground.treporto.entity.registry;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.enums.ShipType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "SHIP")
public class ShipEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String nationality;

    @Column
    private Integer size;

    @Column
    private ShipType type;
}


