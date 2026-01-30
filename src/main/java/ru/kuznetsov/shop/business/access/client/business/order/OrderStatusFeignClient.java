package ru.kuznetsov.shop.business.access.client.business.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.business.access.client.business.AbstractFeignClient;
import ru.kuznetsov.shop.represent.dto.order.OrderStatusDto;
import ru.kuznetsov.shop.represent.enums.OrderStatusType;

import java.util.Collection;
import java.util.Optional;

@FeignClient(
        value = "${service.module-name.order}",
        url = "http://localhost:8761",
        contextId = "OrderStatus",
        path = "/order/status")
public interface OrderStatusFeignClient extends AbstractFeignClient<OrderStatusDto> {

    @GetMapping
    Collection<OrderStatusDto> getAllOrderStatusesByOrderId(@RequestParam Long orderId);

    @GetMapping("/last")
    Optional<OrderStatusDto> getLastByOrderId(@RequestParam Long orderId);

    @GetMapping("/status")
    Collection<OrderStatusDto> getAllByStatus(@RequestParam OrderStatusType status);
}
