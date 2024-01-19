package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
  private RegistrationService registrationService;
@PostMapping("/register")
  public ResponseEntity<String> register (@RequestBody UserDTO userDTO){
  String message = registrationService.register(userDTO);
  return ResponseEntity.status(HttpStatus.CREATED).body(message);
}
}
