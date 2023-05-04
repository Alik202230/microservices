package com.javadev.product.service.service;

import com.javadev.product.service.dto.ProductRequest;
import com.javadev.product.service.dto.ProductResponse;
import com.javadev.product.service.model.Product;
import com.javadev.product.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void createProduct(ProductRequest productRequest) {
    Product product = new Product();
    product.setName(productRequest.getName());
    product.setDescription(productRequest.getDescription());
    product.setPrice(productRequest.getPrice());

    productRepository.save(product);
    log.info("Product with the id of " + product.getId() + " is saved successfully");

  }

  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream()
      .map(this::mapToProductResponse)
      .toList();
  }

  public Optional<ProductResponse> getProductById(String id) {
    return productRepository.findAll()
      .stream()
      .filter(product -> product.getId().equals(id))
      .findFirst()
      .map(this::mapToProductResponse);
  }


  public String deleteProduct(String id) {
    Optional<Product> productOptional = productRepository.findAll()
      .stream()
      .filter(product -> product.getId().equals(id))
      .findFirst();
//      if (productOptional.isPresent()) {
//        productRepository.delete(productOptional.get());
//        return Optional.of(mapToProductResponse(productOptional.get()));
//      } else {
//        return Optional.empty();
//      }
    productOptional.ifPresent(productRepository::delete);
    Optional.of(mapToProductResponse(productOptional.get()));
    return "Product with the id of " + id + " has been deleted successfully";
  }

  private ProductResponse mapToProductResponse(Product product) {
    ProductResponse productResponse = new ProductResponse();
    productResponse.setId(product.getId());
    productResponse.setDescription(product.getDescription());
    productResponse.setName(product.getName());
    productResponse.setPrice(product.getPrice());
    return productResponse;
  }

}
