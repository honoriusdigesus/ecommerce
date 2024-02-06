package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.AuthenticationRequestDTO;
import com.ada.ecommerce.dto.AuthenticationResponse;
import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    public AuthenticationResponse authenticate(AuthenticationRequestDTO requestDTO) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword());
        Authentication authResponse = authenticationManager.authenticate(auth);
        User  user = (User) authResponse.getPrincipal();
        String accessToken = jwtService.create(user);
        return AuthenticationResponse.builder().accessToken(accessToken).build();
    }
}
