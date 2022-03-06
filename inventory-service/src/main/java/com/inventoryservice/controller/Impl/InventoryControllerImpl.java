package com.inventoryservice.controller.Impl;

import com.inventoryservice.controller.api.InventoryControllerApi;
import com.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class InventoryControllerImpl implements InventoryControllerApi {

    private InventoryService inventoryService;

    @Override
    public Boolean isInStock(@PathVariable String SKU) {
        return inventoryService.isProductInStock(SKU);
    }
}
