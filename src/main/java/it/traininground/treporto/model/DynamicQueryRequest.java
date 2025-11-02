package it.traininground.treporto.model;

import it.traininground.treporto.enums.AggregationType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DynamicQueryRequest {
    private String entity;
    private List<String> joins;
    private Map<String, String> fields;
    private Map<String, AggregationType> aggregations;
    private List<DynamicQueryFilter> filters;
    private List<String> groupBy;
}
