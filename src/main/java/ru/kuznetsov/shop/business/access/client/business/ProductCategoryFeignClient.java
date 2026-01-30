package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;

@FeignClient(
        value = "${service.module-name.product-category}",
        path = "/product-category")
public interface ProductCategoryFeignClient extends AbstractFeignClient<ProductCategoryDto> {
}
