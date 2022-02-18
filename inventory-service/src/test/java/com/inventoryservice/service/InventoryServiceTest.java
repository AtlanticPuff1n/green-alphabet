package com.inventoryservice.service;

import com.inventoryservice.model.Inventory;
import com.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {InventoryService.class})
@ExtendWith(SpringExtension.class)
class InventoryServiceTest {
    @MockBean
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryService inventoryService;

    @Test
    void testIsProductInStock() {
        Inventory inventory = new Inventory();
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertTrue(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
    }

    @Test
    void testIsProductInStock2() {
        Inventory inventory = mock(Inventory.class);
        when(inventory.getStock()).thenReturn(1);
        doNothing().when(inventory).setId((Long) any());
        doNothing().when(inventory).setSKU((String) any());
        doNothing().when(inventory).setStock((Integer) any());
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertTrue(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
        verify(inventory).getStock();
        verify(inventory).setId((Long) any());
        verify(inventory).setSKU((String) any());
        verify(inventory).setStock((Integer) any());
    }

    @Test
    void testIsProductInStock3() {
        Inventory inventory = mock(Inventory.class);
        when(inventory.getStock()).thenReturn(0);
        doNothing().when(inventory).setId((Long) any());
        doNothing().when(inventory).setSKU((String) any());
        doNothing().when(inventory).setStock((Integer) any());
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertFalse(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
        verify(inventory).getStock();
        verify(inventory).setId((Long) any());
        verify(inventory).setSKU((String) any());
        verify(inventory).setStock((Integer) any());
    }

    @Test
    void testIsProductInStock4() {
        Inventory inventory = new Inventory();
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertTrue(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
    }

    @Test
    void testIsProductInStock5() {
        Inventory inventory = mock(Inventory.class);
        when(inventory.getStock()).thenReturn(1);
        doNothing().when(inventory).setId((Long) any());
        doNothing().when(inventory).setSKU((String) any());
        doNothing().when(inventory).setStock((Integer) any());
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertTrue(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
        verify(inventory).getStock();
        verify(inventory).setId((Long) any());
        verify(inventory).setSKU((String) any());
        verify(inventory).setStock((Integer) any());
    }

    @Test
    void testIsProductInStock6() {
        Inventory inventory = mock(Inventory.class);
        when(inventory.getStock()).thenReturn(0);
        doNothing().when(inventory).setId((Long) any());
        doNothing().when(inventory).setSKU((String) any());
        doNothing().when(inventory).setStock((Integer) any());
        inventory.setId(123L);
        inventory.setSKU("SKU");
        inventory.setStock(1);
        Optional<Inventory> ofResult = Optional.of(inventory);
        when(this.inventoryRepository.findBySKU((String) any())).thenReturn(ofResult);
        assertFalse(this.inventoryService.isProductInStock("SKU"));
        verify(this.inventoryRepository).findBySKU((String) any());
        verify(inventory).getStock();
        verify(inventory).setId((Long) any());
        verify(inventory).setSKU((String) any());
        verify(inventory).setStock((Integer) any());
    }
}

