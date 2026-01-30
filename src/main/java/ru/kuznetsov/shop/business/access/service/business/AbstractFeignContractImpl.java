package ru.kuznetsov.shop.business.access.service.business;

import ru.kuznetsov.shop.business.access.client.business.AbstractFeignClient;
import ru.kuznetsov.shop.represent.dto.AbstractDto;

import java.util.Collection;
import java.util.List;

public class AbstractFeignContractImpl<E extends AbstractDto, S extends AbstractFeignClient<E>> {

    protected final S client;

    public AbstractFeignContractImpl(S client) {
        this.client = client;
    }

    public E getById(Long id) {
        return client.getById(id);
    }

    public List<E> getAll() {
        return client.getAll();
    }

    public E create(E entity) {
        return client.create(entity);
    }

    public Collection<E> createBatch(Collection<E> entities) {
        return client.createBatch(entities);
    }

    public E update(E entity) {
        return client.update(entity);
    }

    public void delete(Long id) {
        client.delete(id);
    }
}
