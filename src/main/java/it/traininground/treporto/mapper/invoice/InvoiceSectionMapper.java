package it.traininground.treporto.mapper.invoice;

import it.traininground.treporto.entity.invoice.InvoiceSectionEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.InvoiceSectionModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class)
public interface InvoiceSectionMapper extends ModelEntityMapper<InvoiceSectionModel, InvoiceSectionEntity> {
}
