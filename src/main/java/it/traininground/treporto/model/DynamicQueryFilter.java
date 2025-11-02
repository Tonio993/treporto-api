package it.traininground.treporto.model;

import it.traininground.treporto.enums.FilterOperator;
import lombok.Data;

@Data
public class DynamicQueryFilter {
    private String field;
    private FilterOperator operator;
    private Object value;
}
