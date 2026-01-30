package ru.kuznetsov.shop.business.access.client.business.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.business.access.client.business.AbstractFeignClient;
import ru.kuznetsov.shop.represent.dto.order.OrderDto;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        value = "${service.module-name.order}",
        contextId = "Order",
        path = "/order")
public interface OrderFeignClient extends AbstractFeignClient<OrderDto> {

    @GetMapping
    Collection<OrderDto> getAllOrdersByCustomerId(@RequestParam UUID customerId);
}
