package ru.kuznetsov.shop.business.access.service.business;

import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.business.StockFeignClient;
import ru.kuznetsov.shop.represent.contract.business.StockContract;
import ru.kuznetsov.shop.represent.dto.StockDto;

import java.util.Collection;
import java.util.UUID;

@Service
public class StockFeignContractImpl extends AbstractFeignContractImpl<StockDto, StockFeignClient> implements StockContract {

    public StockFeignContractImpl(StockFeignClient client) {
        super(client);
    }

    @Override
    public Collection<StockDto> getAll(Long productId, Long storeId, UUID ownerId) {
        return client.getAll(productId, storeId, ownerId);
    }

    @Override
    public Collection<StockDto> getAllByReservationOrderId(Long orderId) {
        return client.getAllByReservationOrderId(orderId);
    }
}
