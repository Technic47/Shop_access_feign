package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.ProductCategoryFeignClient;
import ru.kuznetsov.shop.represent.contract.business.ProductCategoryContract;
import ru.kuznetsov.shop.represent.dto.ProductCategoryDto;

@Service
public class ProductCategoryFeignContractImpl extends AbstractFeignContractImpl<ProductCategoryDto, ProductCategoryFeignClient> implements ProductCategoryContract {

    public ProductCategoryFeignContractImpl(ProductCategoryFeignClient client) {
        super(client);
    }
}
