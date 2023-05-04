package com.javadev.inventory.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			Inventory inventory = new Inventory();
//			inventory.setSkuCode("Iphone_14");
//			inventory.setQuantity(100);
//		};
//	}

}
