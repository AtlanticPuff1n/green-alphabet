package com.orderservice.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class OrderDTOTest {
    @Test
    void testConstructor() {
        OrderDTO actualOrderDTO = new OrderDTO();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualOrderDTO.setPrice(valueOfResult);
        actualOrderDTO.setQuantity(1);
        actualOrderDTO.setSKU("SKU");
        assertSame(valueOfResult, actualOrderDTO.getPrice());
        assertEquals(1, actualOrderDTO.getQuantity().intValue());
        assertEquals("SKU", actualOrderDTO.getSKU());
    }

    @Test
    void testConstructor2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        OrderDTO actualOrderDTO = new OrderDTO("SKU", valueOfResult, 1);
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualOrderDTO.setPrice(valueOfResult1);
        actualOrderDTO.setQuantity(1);
        actualOrderDTO.setSKU("SKU");
        BigDecimal price = actualOrderDTO.getPrice();
        assertSame(valueOfResult1, price);
        assertEquals(valueOfResult, price);
        assertEquals(1, actualOrderDTO.getQuantity().intValue());
        assertEquals("SKU", actualOrderDTO.getSKU());
    }
}

