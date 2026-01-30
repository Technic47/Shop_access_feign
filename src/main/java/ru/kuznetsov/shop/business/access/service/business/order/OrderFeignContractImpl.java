package ru.kuznetsov.shop.business.access.service.business.order;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.order.OrderFeignClient;
import ru.kuznetsov.shop.business.access.service.business.AbstractFeignContractImpl;
import ru.kuznetsov.shop.represent.contract.order.OrderContract;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class OrderFeignContractImpl extends AbstractFeignContractImpl<OrderDto, OrderFeignClient> implements OrderContract {

    public OrderFeignContractImpl(OrderFeignClient client) {
        super(client);
    }

    @Override
    public Collection<OrderDto> getAllByCustomerId(UUID customerId) {
        return client.getAllOrdersByCustomerId(customerId);
    }
}
