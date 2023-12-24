package com.ada.ecommerce.repository;

import com.ada.ecommerce.entity.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, UUID> {

/*  @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
  Role findRoleByName(String name);
  @Query(value = "SELECT r FROM Role r.name WHERE name = ?1", nativeQuery = true)
  Role findRoleNamed(String name);*/

  Optional<Role> findByName(String name);
}
