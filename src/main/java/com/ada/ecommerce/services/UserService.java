package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.entity.User;
import java.util.UUID;

public interface UserService {
  UserDTO getById(UUID uuid);
  boolean existByEmail(String email);
  User save(User user);;

}
