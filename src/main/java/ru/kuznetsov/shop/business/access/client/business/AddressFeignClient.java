package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import ru.kuznetsov.shop.represent.dto.AddressDto;

@FeignClient(
        value = "${service.module-name.address}",
        path = "/address")
public interface AddressFeignClient extends AbstractFeignClient<AddressDto> {
}
