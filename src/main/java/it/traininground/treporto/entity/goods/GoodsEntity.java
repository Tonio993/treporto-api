package it.traininground.treporto.entity.goods;

import it.traininground.treporto.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "GOODS")
public class GoodsEntity extends BaseEntity {

    @Column
    private String name;

}
