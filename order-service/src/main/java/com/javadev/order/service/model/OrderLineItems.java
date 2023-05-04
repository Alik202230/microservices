package com.javadev.order.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderLineItems {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;

  public OrderLineItems(Long id, String skuCode, BigDecimal price, Integer quantity) {
    this.id = id;
    this.skuCode = skuCode;
    this.price = price;
    this.quantity = quantity;
  }

}
