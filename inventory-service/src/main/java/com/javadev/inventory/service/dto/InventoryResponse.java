package com.javadev.inventory.service.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
public class InventoryResponse {
  private String skuCode;
  private boolean isInStock;

  public InventoryResponse(String skuCode, boolean isInStock) {
    this.skuCode = skuCode;
    this.isInStock = isInStock;
  }

}
