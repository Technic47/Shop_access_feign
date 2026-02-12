package ru.kuznetsov.shop.business.access.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.kuznetsov.shop.represent.dto.OperationDto;
import ru.kuznetsov.shop.represent.dto.OperationPayloadDto;

import java.util.List;
import java.util.Map;

@FeignClient(
        value = "${service.module-name.operation}",
        path = "/operation")
public interface OperationFeignClient {

    @GetMapping(value = "/{id}/contains")
    boolean containsOperation(@PathVariable String id);

    @GetMapping(value = "/{id}")
    OperationDto getOperation(@PathVariable String id);

    @GetMapping(value = "/payload/{id}")
    List<OperationPayloadDto> getOperationData(@PathVariable String id);

    @GetMapping(value = "/payload")
    List<OperationPayloadDto> getOperationData(@RequestBody OperationDto operation);

    @DeleteMapping(value = "/batch")
    void removeOperations(@RequestBody List<OperationDto> operationIds);

    @DeleteMapping
    void removeOperation(@RequestBody OperationDto operation);

    @PostMapping(value = "/payload")
    void addOperations(@RequestBody Map<String, Object> requestMap);

    @GetMapping(value = "/payload/{id}/wait")
    List<Long> getEntityIdsByOperationId(@PathVariable String id);
}
