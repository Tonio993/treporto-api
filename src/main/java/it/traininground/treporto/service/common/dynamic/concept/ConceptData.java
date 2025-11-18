package it.traininground.treporto.service.common.dynamic.concept;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.mapper.common.CommonMapping;
import it.traininground.treporto.model.BaseModel;
import lombok.Data;

@Data
public class ConceptData {

    private final BaseModel model;
    private final BaseEntity entity;
    private final CommonMapping mapping;


    public ConceptData(BaseModel model, BaseEntity entity, CommonMapping mapping) {
        this.model = model;
        this.entity = entity;
        this.mapping = mapping;
    }
}
