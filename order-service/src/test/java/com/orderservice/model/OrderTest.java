package com.orderservice.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class OrderTest {
    @Test
    void testConstructor() {
        Order actualOrder = new Order();
        actualOrder.setId(123L);
        actualOrder.setOrderNumber("42");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualOrder.setPrice(valueOfResult);
        actualOrder.setQuantity(1);
        actualOrder.setSKU("SKU");
        assertEquals(123L, actualOrder.getId().longValue());
        assertEquals("42", actualOrder.getOrderNumber());
        assertSame(valueOfResult, actualOrder.getPrice());
        assertEquals(1, actualOrder.getQuantity().intValue());
        assertEquals("SKU", actualOrder.getSKU());
    }

    @Test
    void testConstructor2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        Order actualOrder = new Order(123L, "42", "SKU", valueOfResult, 1);
        actualOrder.setId(123L);
        actualOrder.setOrderNumber("42");
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualOrder.setPrice(valueOfResult1);
        actualOrder.setQuantity(1);
        actualOrder.setSKU("SKU");
        assertEquals(123L, actualOrder.getId().longValue());
        assertEquals("42", actualOrder.getOrderNumber());
        BigDecimal price = actualOrder.getPrice();
        assertSame(valueOfResult1, price);
        assertEquals(valueOfResult, price);
        assertEquals(1, actualOrder.getQuantity().intValue());
        assertEquals("SKU", actualOrder.getSKU());
    }
}

