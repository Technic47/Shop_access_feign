package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.StoreFeignClient;
import ru.kuznetsov.shop.represent.contract.business.StoreContract;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class StoreFeignContractImpl extends AbstractFeignContractImpl<StoreDto, StoreFeignClient> implements StoreContract {

    public StoreFeignContractImpl(StoreFeignClient client) {
        super(client);
    }

    @Override
    public Collection<StoreDto> getAll(Long id, String name, Long addressId, UUID ownerId) {
        return client.getAll(id, name, addressId, ownerId);
    }
}
