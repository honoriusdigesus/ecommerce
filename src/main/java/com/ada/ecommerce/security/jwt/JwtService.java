package com.ada.ecommerce.security.jwt;

import com.ada.ecommerce.entity.User;
import com.ada.ecommerce.services.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class JwtService {
    public static final String SECRET_KEY = "myk3ys3cr3t";
    private UserService userService;
    public String create(User user) {
        return JWT.create()
                .withSubject(user.getId().toString())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
                .withClaim("role", user.getRole().getName())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public User decodeToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String userId = decodedJWT.getSubject();
        return userService.findById(UUID.fromString(userId));
    }
}
