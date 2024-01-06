package com.ada.ecommerce.dto;

import com.ada.ecommerce.entity.Role;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

  private UUID id;
  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String roleName;

}
