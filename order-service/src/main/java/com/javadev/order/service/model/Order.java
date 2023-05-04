package com.javadev.order.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "t_orders")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String orderNumber;

  @OneToMany(cascade = CascadeType.ALL)
  private List<OrderLineItems> orderLineItemsList;

  public Order(Long id, String orderNumber, List<OrderLineItems> orderLineItemsList) {
    this.id = id;
    this.orderNumber = orderNumber;
    this.orderLineItemsList = orderLineItemsList;
  }


}
