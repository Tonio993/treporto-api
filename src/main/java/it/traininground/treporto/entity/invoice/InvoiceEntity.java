package it.traininground.treporto.entity.invoice;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.entity.port.PortEntity;
import it.traininground.treporto.entity.port.QuayEntity;
import it.traininground.treporto.entity.registry.ClientEntity;
import it.traininground.treporto.entity.registry.CompanyEntity;
import it.traininground.treporto.entity.registry.ShipEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "INVOICE")
public class InvoiceEntity extends BaseEntity {

    @Column
    private String number;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_ship")
    private ShipEntity idShip;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private CompanyEntity company;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_invoice")
    @Fetch(FetchMode.SUBSELECT)
    private List<InvoiceSectionEntity> sectionList;

    @ManyToOne
    @JoinColumn(name = "id_port")
    private PortEntity port;

    @ManyToOne
    @JoinColumn(name = "id_quay")
    private QuayEntity quay;

}
