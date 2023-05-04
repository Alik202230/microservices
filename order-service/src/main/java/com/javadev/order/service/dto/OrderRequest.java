package com.javadev.order.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderRequest {

  private List<OrderLineItemsDto> orderLineItemsDtoList;
  public OrderRequest (List<OrderLineItemsDto> orderLineItemsDtoList) {
    this.orderLineItemsDtoList = orderLineItemsDtoList;
  }

}
