package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.repository.OrderRepository;
import com.ada.ecommerce.services.OrderService;
import java.util.UUID;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class OrderController {

  private OrderService orderService;

  @PostMapping
  private ResponseEntity<String> save(@RequestBody OrderDTO dto) {
    String returnMessage = orderService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(returnMessage);
  }
/*
  @GetMapping("/{id}/price/total")
  public String getTotalPrice(@PathVariable UUID id) {
    double total = orderRepository.getTotalPriceByOrderId(id.toString());
    double total2 = orderRepository.getTotalPrice(id);
    return "Query nativa " + total + " JQPL " + total2;
  }*/

  @GetMapping("/{uuid}")
  public ResponseEntity<OrderDTO> getById(@PathVariable UUID uuid){
    OrderDTO order = orderService.getById(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(order);
  }
}
