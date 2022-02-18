package com.inventoryservice.service;

import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {

    private InventoryRepository inventoryRepository;

    public Boolean isProductInStock(String SKU) {
        Inventory inventory = inventoryRepository.findBySKU(SKU)
                .orElse(Inventory.builder()
                        .stock(0)
                        .build()
                );
        return inventory.getStock() > 0;
    }
}
