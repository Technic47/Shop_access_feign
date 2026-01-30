package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.represent.dto.StockDto;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        value = "${service.module-name.stock}",
        path = "/stock")
public interface StockFeignClient extends AbstractFeignClient<StockDto> {

    @GetMapping("")
    Collection<StockDto> getAll(
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "storeId") Long storeId,
            @RequestParam(value = "ownerId") UUID ownerId
    );

    @GetMapping("/reservation")
    Collection<StockDto> getAllByReservationOrderId(@RequestParam(value = "orderId") Long orderId);
}
