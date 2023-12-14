package it.traininground.treporto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Cliente extends BaseEntity {

    @Column
    private String ragioneSociale;

    @Column
    private String via;

    @Column
    private String citta;

    @Column
    private String partitaIva;

    @Column
    private String codiceUnivoco;

}

