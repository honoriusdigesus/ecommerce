package com.ada.ecommerce.security.jwt;

import com.ada.ecommerce.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class JwtService {
    public static final String SECRET_KEY = "myk3ys3cr3t";
    public String create(User user) {
        return JWT.create()
                .withSubject(user.getId().toString())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
                .withClaim("role", user.getRole().getName())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }
}
