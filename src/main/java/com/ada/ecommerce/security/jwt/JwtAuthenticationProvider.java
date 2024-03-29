package com.ada.ecommerce.security.jwt;

import com.ada.ecommerce.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private JwtService jwtService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken auth = (JwtAuthenticationToken) authentication;
        String accessToken = (String) auth.getPrincipal();
        User user = jwtService.decodeToken(accessToken);
        return new JwtAuthenticationToken(user, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
