package it.traininground.treporto.service.common.dynamic.concept;

import it.traininground.treporto.entity.BaseEntity;
import it.traininground.treporto.mapper.common.CommonMapping;
import it.traininground.treporto.model.BaseModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ConceptManager {

    private List<ConceptData> conceptDataList;
    private Map<BaseModel, ConceptData> modelReference;
    private Map<BaseEntity, ConceptData> entityReference;

    public ConceptManager() {
        conceptDataList = new LinkedList<>();
        modelReference = new HashMap<>();
        entityReference = new HashMap<>();
    }

    public void registerConcept(BaseModel model, BaseEntity entity, CommonMapping mapper) {
        ConceptData concept = new ConceptData(model, entity, mapper);
        conceptDataList.add(concept);
        modelReference.put(model, concept);
        entityReference.put(entity, concept);
    }

}
