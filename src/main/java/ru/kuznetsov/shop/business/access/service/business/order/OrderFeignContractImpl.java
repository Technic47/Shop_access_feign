package ru.kuznetsov.shop.business.access.service.business.order;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.order.OrderFeignClient;
import ru.kuznetsov.shop.business.access.service.business.AbstractFeignContractImpl;
import ru.kuznetsov.shop.represent.contract.OperationContract;
import ru.kuznetsov.shop.represent.contract.order.OrderContract;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class OrderFeignContractImpl extends AbstractFeignContractImpl<OrderDto, OrderFeignClient> implements OrderContract {

    private final OperationContract operationService;

    public OrderFeignContractImpl(OrderFeignClient client, OperationContract operationService) {
        super(client);
        this.operationService = operationService;
    }

    @Override
    public OrderDto create(OrderDto entity) {
        String operationId = client.createWithOperation(entity);
        Long entityId = operationService.getEntityIdsByOperationId(operationId).get(0);

        return getById(entityId);
    }

    @Override
    public Collection<OrderDto> createBatch(Collection<OrderDto> entities) {
        String operationId = client.createBatchWithOperation(entities);

        return operationService.getEntityIdsByOperationId(operationId)
                .stream()
                .map(this::getById)
                .toList();
    }

    @Override
    public Collection<OrderDto> getAllByCustomerId(UUID customerId) {
        return client.getAllOrdersByCustomerId(customerId);
    }
}
