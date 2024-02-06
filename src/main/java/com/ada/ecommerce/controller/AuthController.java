package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.AuthenticationRequestDTO;
import com.ada.ecommerce.dto.AuthenticationResponse;
import com.ada.ecommerce.dto.EmailNotificationDTO;
import com.ada.ecommerce.dto.UserDTO;
import com.ada.ecommerce.services.AuthenticationService;
import com.ada.ecommerce.services.EmailService;
import com.ada.ecommerce.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private RegistrationService registrationService;
    private EmailService emailService;
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        String message = registrationService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PostMapping("/email")
    public String sendEmail() {
        EmailNotificationDTO email = EmailNotificationDTO.builder().to("honoriusdigesus@gmail.com").subject("Prueba").body("Este es un correo de prueba enviado desde Spring").hasTemplate(false).build();
        EmailNotificationDTO email2 = EmailNotificationDTO.builder().to("honoriusdigesus@gmail.com").subject("Prueba").body("<h2>Este es un correo de prueba enviado desde Spring</h2>").hasTemplate(true).build();
        emailService.send(email);
        emailService.send(email2);
        return "Mensaje enviado sin problemas";
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm (@RequestParam String token){
        String message = registrationService.confirm(token);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequestDTO request){
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
