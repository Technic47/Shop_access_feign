package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;
import ru.kuznetsov.shop.represent.dto.ProductDto;
import ru.kuznetsov.shop.represent.dto.util.ProductCardPage;

import java.util.Collection;
import java.util.UUID;

@FeignClient(
        value = "${service.module-name.product}",
        path = "/product")
public interface ProductFeignClient extends AbstractFeignClient<ProductDto> {

    @GetMapping
    Collection<ProductDto> getAllByOwnerId(@RequestParam(value = "ownerId") UUID ownerId);

    @GetMapping
    Collection<ProductDto> getAllByOwnerIdOrCategoryId(
            @RequestParam(value = "ownerId") UUID ownerId,
            @RequestParam(value = "categoryId") Long categoryId
    );

    @GetMapping("/card")
    Collection<ProductCardDto> getProductCardsByOwnerIdAOrCategoryId(
            @RequestParam(value = "ownerId") UUID ownerId,
            @RequestParam(value = "categoryId") Long categoryId
    );

    @GetMapping("/card/page")
    ProductCardPage getProductCardDtoPageable(
            @RequestParam(value = "pageNum") int pageNum,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "sortDirection") String sortDirection
    );

    @GetMapping("/card/page")
    ProductCardPage getProductCardDtoByCategoryOrOwnerIdPageable(
            @RequestParam(value = "ownerId") UUID ownerId,
            @RequestParam(value = "categoryId") Long categoryId,
            @RequestParam(value = "pageNum") int pageNum,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "sortDirection") String sortDirection
    );
}
