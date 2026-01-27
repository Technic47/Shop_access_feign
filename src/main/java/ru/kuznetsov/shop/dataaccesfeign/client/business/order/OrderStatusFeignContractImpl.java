package ru.kuznetsov.shop.dataaccesfeign.client.business.order;

import org.springframework.cloud.openfeign.FeignClient;
import ru.kuznetsov.shop.represent.contract.order.OrderStatusContract;

import static ru.kuznetsov.shop.dataaccesfeign.common.ConstValues.ORDER_MODULE;

@FeignClient(value = ORDER_MODULE)
public interface OrderStatusFeignContractImpl extends OrderStatusContract {
}
