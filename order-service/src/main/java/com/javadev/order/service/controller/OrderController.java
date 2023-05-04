package com.javadev.order.service.controller;

import com.javadev.order.service.dto.OrderRequest;
import com.javadev.order.service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }


  @PostMapping("/place")
  @ResponseStatus(HttpStatus.CREATED)
  public String placeOrder(@RequestBody OrderRequest orderRequest) {
    orderService.placeOrder(orderRequest);
    return "Order placed successfully";
  }

}
