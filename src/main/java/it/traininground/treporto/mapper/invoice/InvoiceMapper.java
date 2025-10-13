package it.traininground.treporto.mapper.invoice;

import it.traininground.treporto.entity.invoice.InvoiceEntity;
import it.traininground.treporto.mapper.common.ModelEntityMapper;
import it.traininground.treporto.model.invoice.InvoiceModel;
import org.mapstruct.Mapper;

@Mapper(config = ModelEntityMapper.class, uses = InvoiceSectionMapper.class)
public interface InvoiceMapper extends ModelEntityMapper<InvoiceModel, InvoiceEntity> {
}
