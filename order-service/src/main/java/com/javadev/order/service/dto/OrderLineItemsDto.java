package com.javadev.order.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderLineItemsDto {

  private Long id;
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;

  public OrderLineItemsDto (Long id, String skuCode, BigDecimal price, Integer quantity) {
    this.id = id;
    this.skuCode = skuCode;
    this.price = price;
    this.quantity = quantity;
  }

}
