package ru.kuznetsov.shop.business.access.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kuznetsov.shop.business.access.client.OperationFeignClient;
import ru.kuznetsov.shop.business.access.client.business.*;
import ru.kuznetsov.shop.business.access.client.business.order.BucketItemFeignClient;
import ru.kuznetsov.shop.business.access.client.business.order.OrderFeignClient;
import ru.kuznetsov.shop.business.access.client.business.order.OrderStatusFeignClient;

@Configuration
@EnableFeignClients(clients = {
        AddressFeignClient.class,
        ProductCategoryFeignClient.class,
        ProductFeignClient.class,
        StockFeignClient.class,
        StoreFeignClient.class,
        BucketItemFeignClient.class,
        OrderFeignClient.class,
        OrderStatusFeignClient.class,
        OperationFeignClient.class
})
@ComponentScan("ru.kuznetsov.shop.business.access")
public class DataAccessConfig {
}
