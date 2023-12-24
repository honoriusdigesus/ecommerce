package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.Role;
import java.util.Optional;

public interface RoleService {
  Role getByName(String name);

}
