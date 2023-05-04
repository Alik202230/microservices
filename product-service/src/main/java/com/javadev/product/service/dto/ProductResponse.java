package com.javadev.product.service.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductResponse {

  private String id;
  private String name;
  private String description;
  private BigDecimal price;
  public ProductResponse(String id, String name, String description, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

}
