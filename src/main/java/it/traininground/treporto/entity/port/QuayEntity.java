package it.traininground.treporto.entity.port;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "QUAY")
public class QuayEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_port")
    private PortEntity port;

    @Column
    private String name;
}
