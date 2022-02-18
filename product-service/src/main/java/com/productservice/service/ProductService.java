package com.productservice.service;

import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    @Cacheable("getAllProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Cacheable("getProduct")
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
