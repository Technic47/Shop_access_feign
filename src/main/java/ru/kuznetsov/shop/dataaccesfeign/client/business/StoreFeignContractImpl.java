package ru.kuznetsov.shop.dataaccesfeign.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuznetsov.shop.represent.contract.business.StoreContract;
import ru.kuznetsov.shop.represent.dto.StoreDto;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.STORE_MODULE;

@FeignClient(value = STORE_MODULE)
public interface StoreFeignContractImpl extends StoreContract {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    Collection<StoreDto> getAll(Long id, String name, Long addressId, UUID ownerId);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    StoreDto getById(Long id);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<StoreDto> getAll();

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "")
    StoreDto create(StoreDto entity);

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/batch")
    Collection<StoreDto> createBatch(Collection<StoreDto> entities);

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "")
    StoreDto update(StoreDto entity);

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(Long id);
}
