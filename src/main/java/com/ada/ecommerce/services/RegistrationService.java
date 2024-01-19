package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.entity.ConfirmationToken;
import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.exception.EmailAlreadyTaken;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

  private UserService userService;
  private ConfirmationTokenService confirmationTokenService;

  public String register(UserDTO userDTO) {
    boolean existEmail = userService.existByEmail(userDTO.getEmail());
    if (existEmail) {
      throw new EmailAlreadyTaken(userDTO.getEmail());
    }
    //TODO: Encrypt password
    User user = new User();
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setAddress(userDTO.getAddress());
    user.setEmail(userDTO.getEmail());
    user.setPassword(userDTO.getPassword());
    User userSaved = userService.save(user);

    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now().plusMinutes(15), userSaved);
    confirmationTokenService.save(confirmationToken);

    //TODO: Send email eith confirmation token
    return "User registered siccessfully with id: " + userSaved.getId() ;
  }
}
