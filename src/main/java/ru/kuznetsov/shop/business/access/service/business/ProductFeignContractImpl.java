package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.ProductFeignClient;
import ru.kuznetsov.shop.represent.contract.business.ProductContract;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;
import ru.kuznetsov.shop.represent.dto.ProductDto;
import ru.kuznetsov.shop.represent.dto.util.ProductCardPage;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProductFeignContractImpl extends AbstractFeignContractImpl<ProductDto, ProductFeignClient> implements ProductContract {

    public ProductFeignContractImpl(ProductFeignClient client) {
        super(client);
    }

    @Override
    public Collection<ProductDto> getAllByOwnerId(UUID ownerId) {
        return client.getAllByOwnerId(ownerId);
    }

    @Override
    public Collection<ProductDto> getAllByOwnerIdOrCategoryId(UUID ownerId, Long categoryId) {
        return client.getAllByOwnerIdOrCategoryId(ownerId, categoryId);
    }

    @Override
    public Collection<ProductCardDto> getProductCardsByOwnerIdAOrCategoryId(UUID ownerId, Long categoryId) {
        return client.getProductCardsByOwnerIdAOrCategoryId(ownerId, categoryId);
    }

    @Override
    public ProductCardPage getProductCardDtoPageable(int pageNum, int pageSize, String sortBy, String sortDirection) {
        return client.getProductCardDtoPageable(pageNum, pageSize, sortBy, sortDirection);
    }

    @Override
    public ProductCardPage getProductCardDtoByCategoryOrOwnerIdPageable(UUID ownerId, Long categoryId, int pageNum, int pageSize, String sortBy, String sortDirection) {
        return client.getProductCardDtoByCategoryOrOwnerIdPageable(ownerId, categoryId, pageNum, pageSize, sortBy, sortDirection);
    }
}
