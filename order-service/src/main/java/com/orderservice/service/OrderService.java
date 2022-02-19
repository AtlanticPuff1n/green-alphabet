package com.orderservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.orderservice.client.InventoryClient;
import com.orderservice.dto.OrderDTO;
import com.orderservice.model.Order;
import com.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private InventoryClient inventoryClient;

    @HystrixCommand(fallbackMethod = "placeOrderFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String addOrder(OrderDTO orderDTO) {
        boolean isProductInStock = inventoryClient.checkStock(orderDTO.getSKU());

        if (isProductInStock) {
            Order order = Order.builder()
                    .orderNumber(UUID.randomUUID().toString())
                    .SKU(orderDTO.getSKU())
                    .price(orderDTO.getPrice())
                    .quantity(orderDTO.getQuantity())
                    .build();
            orderRepository.save(order);
            return "Order placed successfully";
        } else {
            return "The product in the order is out of stock";
        }
    }

    private String placeOrderFallback(OrderDTO orderDTO) {
        return "Request fails. It takes long time to response";
    }
}
