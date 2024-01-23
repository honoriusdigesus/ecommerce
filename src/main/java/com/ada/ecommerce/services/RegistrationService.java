package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.EmailNotificationDTO;
import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.entity.ConfirmationToken;
import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.exception.EmailAlreadyTaken;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ada.ecommerce.util.TemplateGenerator;
import com.ada.ecommerce.util.UrlGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private UserService userService;
    private ConfirmationTokenService confirmationTokenService;
    private EmailService emailService;

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
        String url = UrlGenerator.create("/auth/confirm", "token", token);
        String template = TemplateGenerator.generateTemplateConfirmationToken(userSaved.getFirstName(), url);
        EmailNotificationDTO email = EmailNotificationDTO
                .builder()
                .to(userSaved.getEmail())
                .subject("Account confirmation")
                .body(template)
                .hasTemplate(true)
                .build();
        emailService.send(email);

        return "User registered successfully with id: " + userSaved.getId();
    }

    public String confirm(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getByToken(token);
        if (confirmationToken.getConfirmedAt() != null) {
            throw new RuntimeException("Token is already confirmed");
        }
        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }
        userService.enableUser(confirmationToken.getUser());
        confirmationTokenService.setConfirmedAt(confirmationToken);
        return "Account confirmed successfully";
    }
}
