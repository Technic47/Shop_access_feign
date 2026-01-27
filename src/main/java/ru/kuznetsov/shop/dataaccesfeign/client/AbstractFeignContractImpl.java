//package ru.kuznetsov.shop.dataaccesfeign.client;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.kuznetsov.shop.represent.contract.business.AbstractContract;
//import ru.kuznetsov.shop.represent.dto.AbstractDto;
//
//import java.util.Collection;
//import java.util.List;
//
//public interface AbstractFeignContractImpl<E extends AbstractDto> extends AbstractContract<E> {
//
//    @Override
//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    E getById(Long id);
//
//    @Override
//    List<E> getAll();
//
//    @Override
//    E create(E entity);
//
//    @Override
//    Collection<E> createBatch(Collection<E> entities);
//
//    @Override
//    E update(E entity);
//
//    @Override
//    void delete(Long id);
//}
