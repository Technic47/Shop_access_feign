package ru.kuznetsov.shop.dataaccesfeign.client.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kuznetsov.shop.represent.contract.business.AddressContract;
import ru.kuznetsov.shop.represent.dto.AddressDto;

import java.util.Collection;
import java.util.List;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.ADDRESS_MODULE;

@FeignClient(value = ADDRESS_MODULE)
public interface AddressFeignContractImpl extends AddressContract {

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    AddressDto getById(Long id);

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<AddressDto> getAll();

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "")
    AddressDto create(AddressDto entity);

    @Override
    @RequestMapping(method = RequestMethod.POST, value = "/batch")
    Collection<AddressDto> createBatch(Collection<AddressDto> entities);

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "")
    AddressDto update(AddressDto entity);

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void delete(Long id);
}
