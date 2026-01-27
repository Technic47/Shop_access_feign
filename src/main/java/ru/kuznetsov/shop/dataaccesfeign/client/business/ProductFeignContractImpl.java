package ru.kuznetsov.shop.dataaccesfeign.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuznetsov.shop.represent.contract.business.ProductContract;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;
import ru.kuznetsov.shop.represent.dto.ProductDto;
import ru.kuznetsov.shop.represent.dto.util.ProductCardPage;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.PRODUCT_MODULE;

@FeignClient(value = PRODUCT_MODULE)
public interface ProductFeignContractImpl extends ProductContract {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    Collection<ProductDto> getAllByOwnerId(UUID ownerId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    Collection<ProductDto> getAllByOwnerIdOrCategoryId(UUID ownerId, Long categoryId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/card")
    Collection<ProductCardDto> getProductCardsByOwnerIdAOrCategoryId(UUID ownerId, Long categoryId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/card/page")
    ProductCardPage getProductCardDtoPageable(int pageNum, int pageSize, String sortBy, String sortDirection);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/card/page")
    ProductCardPage getProductCardDtoByCategoryOrOwnerIdPageable(UUID ownerId, Long categoryId, int pageNum, int pageSize, String sortBy, String sortDirection);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    ProductDto getById(Long id);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<ProductDto> getAll();

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "")
    ProductDto create(ProductDto entity);

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/batch")
    Collection<ProductDto> createBatch(Collection<ProductDto> entities);

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "")
    ProductDto update(ProductDto entity);

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(Long id);
}
