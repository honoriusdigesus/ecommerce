package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;

  @Override
  public User getById(UUID id) {
    return userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User not found"));
  }
}
