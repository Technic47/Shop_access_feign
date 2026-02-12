package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    String createWithOperation(@RequestBody StockDto entity);

    @PostMapping
    String createBatchWithOperation(@RequestBody Collection<StockDto> entities);

    /*
    Не использовать метод
     */
    @Override
    @Deprecated
    @PostMapping
    StockDto create(StockDto entity);

    /*
    Не использовать метод
     */
    @Override
    @Deprecated
    @PostMapping
    Collection<StockDto> createBatch(Collection<StockDto> entities);

    @GetMapping("/reservation")
    Collection<StockDto> getAllByReservationOrderId(@RequestParam(value = "orderId") Long orderId);
}
