package com.productservice.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ProductTest {
    @Test
    void testConstructor() {
        Product actualProduct = new Product();
        actualProduct.setId(123L);
        actualProduct.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualProduct.setPrice(valueOfResult);
        assertEquals(123L, actualProduct.getId().longValue());
        assertEquals("Name", actualProduct.getName());
        assertSame(valueOfResult, actualProduct.getPrice());
    }

    @Test
    void testConstructor2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        Product actualProduct = new Product(123L, "Name", valueOfResult);
        actualProduct.setId(123L);
        actualProduct.setName("Name");
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualProduct.setPrice(valueOfResult1);
        assertEquals(123L, actualProduct.getId().longValue());
        assertEquals("Name", actualProduct.getName());
        BigDecimal price = actualProduct.getPrice();
        assertSame(valueOfResult1, price);
        assertEquals(valueOfResult, price);
    }
}

