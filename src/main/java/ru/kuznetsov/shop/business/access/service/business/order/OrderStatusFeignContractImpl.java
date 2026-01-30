package ru.kuznetsov.shop.business.access.service.business.order;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.service.business.AbstractFeignContractImpl;
import ru.kuznetsov.shop.business.access.client.business.order.OrderStatusFeignClient;
import ru.kuznetsov.shop.represent.contract.order.OrderStatusContract;
import ru.kuznetsov.shop.represent.dto.order.OrderStatusDto;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.util.Collection;
import java.util.Optional;

@Service
public class OrderStatusFeignContractImpl extends AbstractFeignContractImpl<OrderStatusDto, OrderStatusFeignClient> implements OrderStatusContract {

    public OrderStatusFeignContractImpl(OrderStatusFeignClient client) {
        super(client);
    }

    @Override
    public Collection<OrderStatusDto> getAllByOrderId(Long orderId) {
        return client.getAllOrderStatusesByOrderId(orderId);
    }

    @Override
    public Optional<OrderStatusDto> getLastByOrderId(Long orderId) {
        return client.getLastByOrderId(orderId);
    }

    @Override
    public Collection<OrderStatusDto> getAllByStatus(OrderStatusType status) {
        return client.getAllByStatus(status);
    }
}
