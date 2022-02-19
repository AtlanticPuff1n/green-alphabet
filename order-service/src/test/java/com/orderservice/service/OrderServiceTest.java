package com.orderservice.service;

import com.orderservice.client.InventoryClient;
import com.orderservice.dto.OrderDTO;
import com.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @MockBean
    private InventoryClient inventoryClient;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    void testAddOrder() {
        when(this.inventoryClient.checkStock((String) any())).thenReturn(false);
        assertEquals("The product in the order is out of stock", this.orderService.addOrder(new OrderDTO()));
    }

    @Test
    void testAddOrder2() {
        when(this.inventoryClient.checkStock((String) any())).thenReturn(true);
        assertEquals("Order placed successfully", this.orderService.addOrder(new OrderDTO()));
    }

    @Test
    void testAddOrder3() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setQuantity(-1);
        assertEquals("The product in the order is out of stock", this.orderService.addOrder(orderDTO));
    }
}