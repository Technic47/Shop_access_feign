package ru.kuznetsov.shop.dataaccesfeign.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuznetsov.shop.represent.contract.business.StockContract;
import ru.kuznetsov.shop.represent.dto.StockDto;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.STOCK_MODULE;

@FeignClient(value = STOCK_MODULE)
public interface StockFeignContractImpl extends StockContract {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    Collection<StockDto> getAll(Long productId, Long storeId, UUID ownerId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/reservation")
    Collection<StockDto> getAllByReservationOrderId(Long orderId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    StockDto getById(Long id);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<StockDto> getAll();

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "")
    StockDto create(StockDto entity);

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/batch")
    Collection<StockDto> createBatch(Collection<StockDto> entities);

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "")
    StockDto update(StockDto entity);

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(Long id);
}
