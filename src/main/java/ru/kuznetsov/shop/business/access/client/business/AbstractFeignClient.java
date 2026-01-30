package ru.kuznetsov.shop.business.access.client.business;

import org.springframework.web.bind.annotation.*;
import ru.kuznetsov.shop.represent.dto.AbstractDto;

import java.util.Collection;
import java.util.List;

public interface AbstractFeignClient<E extends AbstractDto> {

    @GetMapping(value = "/{id}")
    E getById(@PathVariable Long id);

    @GetMapping
    List<E> getAll();

    @PostMapping
    E create(@RequestBody E entity);

    @PostMapping(value = "/batch")
    Collection<E> createBatch(@RequestBody Collection<E> entities);

    @PutMapping
    E update(@RequestBody E entity);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Long id);
}
