package it.traininground.treporto.model;

import it.traininground.treporto.enums.TipoNave;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Nave extends BaseEntity {

    @Column
    private String nome;

    @Column
    private String nazionalita;

    @Column
    private int stazza;

    @Column
    private TipoNave tipo;
}


