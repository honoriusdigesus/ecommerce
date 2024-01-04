package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.User;
import java.util.UUID;

public interface UserService {
  User getById(UUID id);

}
