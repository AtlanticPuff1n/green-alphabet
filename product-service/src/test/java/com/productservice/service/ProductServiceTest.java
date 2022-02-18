package com.productservice.service;

import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        when(this.productRepository.findAll()).thenReturn(productList);
        List<Product> actualAllProducts = this.productService.getAllProducts();
        assertSame(productList, actualAllProducts);
        assertTrue(actualAllProducts.isEmpty());
        verify(this.productRepository).findAll();
    }

    @Test
    void testGetProduct() {
        Product product = new Product();
        product.setId(123L);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Product> actualProduct = this.productService.getProduct(123L);
        assertSame(ofResult, actualProduct);
        assertTrue(actualProduct.isPresent());
        assertEquals("42", actualProduct.get().getPrice().toString());
        verify(this.productRepository).findById((Long) any());
        assertTrue(this.productService.getAllProducts().isEmpty());
    }

    @Test
    void testSaveProduct() {
        Product product = new Product();
        product.setId(123L);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        when(this.productRepository.save((Product) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setId(123L);
        product1.setName("Name");
        product1.setPrice(BigDecimal.valueOf(42L));
        this.productService.saveProduct(product1);
        verify(this.productRepository).save((Product) any());
        assertTrue(this.productService.getAllProducts().isEmpty());
    }
}

