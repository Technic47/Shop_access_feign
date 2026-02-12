package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.StockFeignClient;
import ru.kuznetsov.shop.represent.contract.OperationContract;
import ru.kuznetsov.shop.represent.contract.business.StockContract;
import ru.kuznetsov.shop.represent.dto.StockDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class StockFeignContractImpl extends AbstractFeignContractImpl<StockDto, StockFeignClient> implements StockContract {

    private final OperationContract operationService;

    public StockFeignContractImpl(StockFeignClient client, OperationContract operationService) {
        super(client);
        this.operationService = operationService;
    }

    @Override
    public Collection<StockDto> getAll(Long productId, Long storeId, UUID ownerId) {
        return client.getAll(productId, storeId, ownerId);
    }

    @Override
    public StockDto create(StockDto entity) {
        String operationId = client.createWithOperation(entity);
        Long entityId = operationService.getEntityIdsByOperationId(operationId).get(0);

        return getById(entityId);
    }

    @Override
    public Collection<StockDto> createBatch(Collection<StockDto> entities) {
        String operationId = client.createBatchWithOperation(entities);

        return operationService.getEntityIdsByOperationId(operationId)
                .stream()
                .map(this::getById)
                .toList();
    }

    @Override
    public Collection<StockDto> getAllByReservationOrderId(Long orderId) {
        return client.getAllByReservationOrderId(orderId);
    }
}
