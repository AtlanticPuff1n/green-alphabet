package com.inventoryservice.controller.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public interface InventoryControllerApi {

    @ApiOperation(value = "Returns true if the item is in stock otherwise false")
    @GetMapping("/{SKU}")
    Boolean isInStock(@PathVariable String SKU);
}
