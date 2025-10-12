package it.traininground.treporto.service;

import it.traininground.treporto.entity.registry.ShipEntity;
import it.traininground.treporto.mapper.registry.ShipMapper;
import it.traininground.treporto.model.registry.ShipModel;
import it.traininground.treporto.repository.ShipRepository;
import it.traininground.treporto.service.common.CommonRepositoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
public class ShipService {

    private final ShipRepository invoiceRepository;
    private final ShipMapper shipMapper;
    private final CommonRepositoryService commonRepositoryService;

    public ShipService(ShipRepository invoiceRepository, ShipMapper shipMapper, CommonRepositoryService commonRepositoryService) {
        this.invoiceRepository = invoiceRepository;
        this.shipMapper = shipMapper;
        this.commonRepositoryService = commonRepositoryService;
    }

    public List<ShipModel> get(Map<String, String> filter) {
        return StreamSupport.stream(commonRepositoryService.get(ShipEntity.class, filter).spliterator(), false).map(shipMapper::toModel).toList();
    }

    public void add(ShipModel invoice) {
        ShipEntity shipEntity = shipMapper.toEntity(invoice);
        invoiceRepository.save(shipEntity);
    }
}
