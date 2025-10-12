package it.traininground.treporto.entity.registry;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "CLIENT")
public class ClientEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String vat;

    @Column
    private String uniqueCode;

}

