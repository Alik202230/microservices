package com.javadev.inventory.service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_inventory")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String skuCode;
  private Integer quantity;

}
