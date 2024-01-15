package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.UserDTO;
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
  public UserDTO getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(()->new EntityNotFoundException("User not found"));
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setAddress(user.getAddress());
    userDTO.setEmail(user.getEmail());
    userDTO.setRoleName(user.getRole().getName());
    return userDTO;
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

}
