package com.javadev.inventory.service.controller;

import com.javadev.inventory.service.dto.InventoryResponse;
import com.javadev.inventory.service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

  private final InventoryService inventoryService;

  public InventoryController (InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
    return inventoryService.isInStock(skuCode);
  }

}
