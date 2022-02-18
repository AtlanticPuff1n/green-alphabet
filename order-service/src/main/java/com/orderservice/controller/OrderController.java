package com.orderservice.controller;

import com.orderservice.dto.OrderDTO;
import com.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody OrderDTO orderDto) {
        return orderService.addOrder(orderDto);
    }
}
