package ru.kuznetsov.shop.business.access.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.shop.business.access.client.OperationFeignClient;
import ru.kuznetsov.shop.represent.contract.OperationContract;
import ru.kuznetsov.shop.represent.dto.OperationDto;
import ru.kuznetsov.shop.represent.dto.OperationPayloadDto;
import ru.kuznetsov.shop.represent.enums.OperationType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OperationFeignContractImpl implements OperationContract {

    private final OperationFeignClient client;

    @Override
    public boolean containsOperation(String operationId) {
        return client.containsOperation(operationId);
    }

    @Override
    public OperationDto getOperation(String operationId) {
        return client.getOperation(operationId);
    }

    @Override
    public List<OperationPayloadDto> getOperationData(String operationId) {
        return client.getOperationData(operationId);
    }

    @Override
    public List<OperationPayloadDto> getOperationData(OperationDto operation) {
        return client.getOperationData(operation);
    }

    @Override
    public void removeOperations(List<OperationDto> operationIds) {
        client.removeOperations(operationIds);
    }

    @Override
    public void removeOperation(OperationDto operation) {
        client.removeOperation(operation);
    }

    @Override
    public void addOperations(String objectJson, String operationId, OperationType type, int result) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("objectJson", objectJson);
        requestMap.put("operationId", operationId);
        requestMap.put("operationType", type);
        requestMap.put("result", result);

        client.addOperations(requestMap);
    }

    @Override
    public List<Long> getEntityIdsByOperationId(String operationId) {
        return client.getEntityIdsByOperationId(operationId);
    }
}
