package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.ProductFeignClient;
import ru.kuznetsov.shop.represent.contract.OperationContract;
import ru.kuznetsov.shop.represent.contract.business.ProductContract;
import ru.kuznetsov.shop.represent.dto.ProductCardDto;
import ru.kuznetsov.shop.represent.dto.ProductDto;
import ru.kuznetsov.shop.represent.dto.util.ProductCardPage;

import java.util.Collection;
import java.util.UUID;

@Service
public class ProductFeignContractImpl extends AbstractFeignContractImpl<ProductDto, ProductFeignClient> implements ProductContract {

    private final OperationContract operationService;

    public ProductFeignContractImpl(ProductFeignClient client, OperationContract operationService) {
        super(client);
        this.operationService = operationService;
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
    public ProductDto create(ProductDto entity) {
        String operationId = client.createWithOperation(entity);
        Long entityId = operationService.getEntityIdsByOperationId(operationId).get(0);

        return getById(entityId);
    }

    @Override
    public Collection<ProductDto> createBatch(Collection<ProductDto> entities) {
        String operationId = client.createBatchWithOperation(entities);

        return operationService.getEntityIdsByOperationId(operationId)
                .stream()
                .map(this::getById)
                .toList();
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
