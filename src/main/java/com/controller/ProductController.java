package com.controller;
import com.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.dto.ProductDto;
import com.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProductsDto() {
        return ResponseEntity.ok(productService.getAllProductsDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductsByUserId(@RequestParam("userId") Long userId) {
        List<ProductDto> products = productService.getProductsByUserId(userId);
        return ResponseEntity.ok(products);
    }



}