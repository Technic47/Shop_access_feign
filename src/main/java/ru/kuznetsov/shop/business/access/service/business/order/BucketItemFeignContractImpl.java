package ru.kuznetsov.shop.business.access.service.business.order;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.order.BucketItemFeignClient;
import ru.kuznetsov.shop.business.access.service.business.AbstractFeignContractImpl;
import ru.kuznetsov.shop.represent.contract.order.BucketItemContract;
import ru.kuznetsov.shop.represent.dto.order.BucketItemDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class BucketItemFeignContractImpl extends AbstractFeignContractImpl<BucketItemDto, BucketItemFeignClient> implements BucketItemContract {

    public BucketItemFeignContractImpl(BucketItemFeignClient client) {
        super(client);
    }

    @Override
    public Collection<BucketItemDto> getAllByCustomerId(UUID customerId) {
        return client.getAllBucketsByCustomerId(customerId);
    }

    @Override
    public Collection<BucketItemDto> getAllByOrderId(Long orderId) {
        return client.getAllByOrderId(orderId);
    }
}
