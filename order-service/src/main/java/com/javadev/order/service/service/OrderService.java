package com.javadev.order.service.service;

import com.javadev.order.service.OrderRepository;
import com.javadev.order.service.dto.InventoryResponse;
import com.javadev.order.service.dto.OrderLineItemsDto;
import com.javadev.order.service.dto.OrderRequest;
import com.javadev.order.service.model.Order;
import com.javadev.order.service.model.OrderLineItems;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService implements OrderServiceImplement{

  private final OrderRepository orderRepository;
  private final WebClient webClient;

  public OrderService (OrderRepository orderRepository, WebClient webClient) {
    this.orderRepository = orderRepository;
    this.webClient = webClient;
  }

  @Override
  public void placeOrder(OrderRequest orderRequest) {
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
      .stream()
      .map(orderLineItemsDto -> mapToDto(orderLineItemsDto))
      .toList();


    order.setOrderLineItemsList(orderLineItems);

    List<String> skuCodes = order.getOrderLineItemsList().stream()
      .map(orderLineItem -> orderLineItem.getSkuCode())
      .toList();

    // Call Inventory service and place order if product is in stock
    InventoryResponse[] inventoryResponseArray = webClient.get()
        .uri("http://localhost:9200/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();

    boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());

    if (allProductsInStock) {
      orderRepository.save(order);
    } else {
      throw new IllegalArgumentException("Product is not in stock, please try again later");
    }

  }

  private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;
  }
}
