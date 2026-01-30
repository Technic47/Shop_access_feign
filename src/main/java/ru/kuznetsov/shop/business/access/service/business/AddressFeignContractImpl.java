package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.AddressFeignClient;
import ru.kuznetsov.shop.represent.contract.business.AddressContract;
import ru.kuznetsov.shop.represent.dto.AddressDto;

@Service
public class AddressFeignContractImpl extends AbstractFeignContractImpl<AddressDto, AddressFeignClient> implements AddressContract {

    public AddressFeignContractImpl(AddressFeignClient client) {
        super(client);
    }
}
