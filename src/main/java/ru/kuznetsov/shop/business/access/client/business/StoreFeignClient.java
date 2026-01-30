package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        value = "${service.module-name.store}",
        path = "/store")
public interface StoreFeignClient extends AbstractFeignClient<StoreDto> {

    @GetMapping
    Collection<StoreDto> getAll(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "addressId") Long addressId,
            @RequestParam(value = "ownerId") UUID ownerId
    );
}
