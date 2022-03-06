package com.productservice.controller.Impl;

import com.productservice.controller.api.ProductControllerApi;
import com.productservice.model.Product;
import com.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductControllerImpl implements ProductControllerApi {

    private ProductService productService;

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @Override
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
