package com.inventoryservice.repository;

import com.inventoryservice.model.Inventory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class InventoryRepositoryTest {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    void testFindBySKU() {
        Inventory inventory = new Inventory();
        inventory.setSKU("SKU");
        inventory.setStock(1);

        Inventory inventory1 = new Inventory();
        inventory1.setSKU("SKU");
        inventory1.setStock(1);
        this.inventoryRepository.save(inventory);
        this.inventoryRepository.save(inventory1);
        assertFalse(this.inventoryRepository.findBySKU("foo").isPresent());
    }
}

