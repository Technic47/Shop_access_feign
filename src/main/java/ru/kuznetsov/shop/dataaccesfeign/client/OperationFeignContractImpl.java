package ru.kuznetsov.shop.dataaccesfeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.kuznetsov.shop.represent.contract.OperationContract;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.OPERATION_MODULE;

@FeignClient(value = OPERATION_MODULE)
public interface OperationFeignContractImpl extends OperationContract {
}
