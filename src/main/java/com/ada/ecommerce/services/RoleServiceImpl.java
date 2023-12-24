package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.Role;
import com.ada.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
  private RoleRepository roleRepository;


  @Override
  public Role getByName(String name) {

    return roleRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Role not found"));
  }
}
