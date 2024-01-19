package com.ada.ecommerce.dto;

import com.ada.ecommerce.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
}
