package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.services.UserService;
import java.util.UUID;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

  private UserService userService;
  @GetMapping("/{id}")
  @SecurityRequirement(name = "BearerAuth")
  public ResponseEntity<UserDTO> getById(@PathVariable UUID id){
    UserDTO user = userService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}
