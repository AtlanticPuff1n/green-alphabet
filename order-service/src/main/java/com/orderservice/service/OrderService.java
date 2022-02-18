package com.orderservice.service;

import com.orderservice.client.InventoryClient;
import com.orderservice.dto.OrderDTO;
import com.orderservice.model.Order;
import com.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private InventoryClient inventoryClient;
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    public String addOrder(OrderDTO orderDTO) {
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
        boolean isProductInStock = circuitBreaker.run(
                () -> inventoryClient.checkStock(orderDTO.getSKU()),
                throwable -> handleErrorCase()
        );

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

    private Boolean handleErrorCase() {
        return false;
    }
}
