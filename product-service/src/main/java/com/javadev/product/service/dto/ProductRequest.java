package com.javadev.product.service.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductRequest {

  private String name;
  private String description;
  private BigDecimal price;

  public ProductRequest(String name, String description, BigDecimal price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

}
