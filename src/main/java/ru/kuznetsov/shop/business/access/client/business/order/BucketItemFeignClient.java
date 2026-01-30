package ru.kuznetsov.shop.business.access.client.business.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.business.access.client.business.AbstractFeignClient;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        value = "${service.module-name.order}",
        contextId = "BucketItem",
        path = "/order/bucket")
public interface BucketItemFeignClient extends AbstractFeignClient<BucketItemDto> {

    @GetMapping
    Collection<BucketItemDto> getAllBucketsByCustomerId(@RequestParam UUID customerId);

    @GetMapping
    Collection<BucketItemDto> getAllByOrderId(@RequestParam Long orderId);
}
