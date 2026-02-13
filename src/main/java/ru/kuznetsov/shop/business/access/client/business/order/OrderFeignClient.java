package ru.kuznetsov.shop.business.access.client.business.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    String createWithOperation(@RequestBody OrderDto entity);

    @PostMapping(value = "/batch")
    String createBatchWithOperation(@RequestBody Collection<OrderDto> entities);

    /*
    Не использовать метод
     */
    @Override
    @Deprecated
    @PostMapping
    OrderDto create(OrderDto entity);

    /*
    Не использовать метод
     */
    @Override
    @Deprecated
    @PostMapping(value = "/batch")
    Collection<OrderDto> createBatch(Collection<OrderDto> entities);

    @GetMapping
    Collection<OrderDto> getAllOrdersByCustomerId(@RequestParam UUID customerId);
}
