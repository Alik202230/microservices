package com.javadev.product.service.controller;

import com.javadev.product.service.dto.ProductRequest;
import com.javadev.product.service.dto.ProductResponse;
import com.javadev.product.service.model.Product;
import com.javadev.product.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  public ProductController (ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody ProductRequest productRequest) {
    productService.createProduct(productRequest);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponse> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Optional<ProductResponse> getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteProductById(@PathVariable String id) {
    productService.deleteProduct(id);
  }

}
