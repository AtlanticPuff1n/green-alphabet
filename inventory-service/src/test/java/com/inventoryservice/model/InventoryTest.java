package com.inventoryservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {
    @Test
    void testConstructor() {
        Inventory actualInventory = new Inventory();
        actualInventory.setId(123L);
        actualInventory.setSKU("SKU");
        actualInventory.setStock(1);
        assertEquals(123L, actualInventory.getId().longValue());
        assertEquals("SKU", actualInventory.getSKU());
        assertEquals(1, actualInventory.getStock().intValue());
    }

    @Test
    void testConstructor2() {
        Inventory actualInventory = new Inventory(123L, "SKU", 1);
        actualInventory.setId(123L);
        actualInventory.setSKU("SKU");
        actualInventory.setStock(1);
        assertEquals(123L, actualInventory.getId().longValue());
        assertEquals("SKU", actualInventory.getSKU());
        assertEquals(1, actualInventory.getStock().intValue());
    }
}

