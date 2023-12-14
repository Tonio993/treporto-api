package it.traininground.treporto.model;

import it.traininground.treporto.enums.TipoFattura;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Fattura extends BaseEntity {

    @Column
    private String numero;

    @Column
    private TipoFattura tipo;

    @Column
    private LocalDate data;

}
