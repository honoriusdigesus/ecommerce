package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderController {

  private OrderService orderService;

  @PostMapping
  private ResponseEntity<String> save(@RequestBody OrderDTO dto) {
    String returnMessage = orderService.save(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(returnMessage);
  }
}
