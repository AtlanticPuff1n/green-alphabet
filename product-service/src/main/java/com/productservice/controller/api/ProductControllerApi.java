package com.productservice.controller.api;

import com.productservice.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public interface ProductControllerApi {

    @ApiOperation(value = "Returns all products")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Product> getAllProducts();

    @ApiOperation(value = "Returns a product by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Optional<Product> getProduct(@PathVariable Long id);

    @ApiOperation(value = "Add a product")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Product successfully added")
            }
    )
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    void addProduct(@RequestBody Product product);

}
