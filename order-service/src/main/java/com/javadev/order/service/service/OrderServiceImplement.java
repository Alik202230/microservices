package com.javadev.order.service.service;

import com.javadev.order.service.dto.OrderRequest;

public interface OrderServiceImplement {
  void placeOrder(OrderRequest orderRequest);
}
