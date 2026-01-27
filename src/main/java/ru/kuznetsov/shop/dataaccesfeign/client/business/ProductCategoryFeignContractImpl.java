package ru.kuznetsov.shop.dataaccesfeign.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuznetsov.shop.represent.contract.business.ProductCategoryContract;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;

import java.util.Collection;
import java.util.List;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.PRODUCT_CATEGORY_MODULE;

@FeignClient(value = PRODUCT_CATEGORY_MODULE)
public interface ProductCategoryFeignContractImpl extends ProductCategoryContract {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    ProductCategoryDto getById(Long id);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<ProductCategoryDto> getAll();

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "")
    ProductCategoryDto create(ProductCategoryDto entity);

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/batch")
    Collection<ProductCategoryDto> createBatch(Collection<ProductCategoryDto> entities);

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "")
    ProductCategoryDto update(ProductCategoryDto entity);

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(Long id);
}
