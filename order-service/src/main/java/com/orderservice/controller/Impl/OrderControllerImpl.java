package com.orderservice.controller.Impl;

import com.orderservice.controller.api.OrderControllerApi;
import com.orderservice.dto.OrderDTO;
import com.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderControllerImpl implements OrderControllerApi {

    private OrderService orderService;

    @Override
    public String addOrder(@RequestBody OrderDTO orderDto) {
        return orderService.addOrder(orderDto);
    }
}
