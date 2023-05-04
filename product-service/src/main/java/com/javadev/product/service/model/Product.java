package com.javadev.product.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
  @Id
  private String id;
  private String name;
  private String description;
  private BigDecimal price;

  public Product(String name, String description, BigDecimal price) {
    super();
    this.name = name;
    this.description = description;
    this.price = price;
  }

}
