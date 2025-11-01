package it.traininground.treporto.entity.port;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "PORT")
public class PortEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany
    @JoinColumn(name = "id_port")
    @Fetch(FetchMode.SUBSELECT)
    private List<QuayEntity> quayList;

}
