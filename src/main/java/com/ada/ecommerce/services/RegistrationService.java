package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.entity.ConfirmationToken;
import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.exception.EmailAlreadyTaken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private UserService userService;
  private ConfirmationTokenService confirmationTokenService;

  public void register(UserDTO userDTO) {
    boolean existEmail = userService.existByEmail(userDTO.getEmail());
    if (existEmail) {
      throw new EmailAlreadyTaken(userDTO.getEmail());
    }
    //TODO: Encrypt password
    User user = new User();
    ConfirmationToken confirmationToken = new ConfirmationToken();
  }
}
