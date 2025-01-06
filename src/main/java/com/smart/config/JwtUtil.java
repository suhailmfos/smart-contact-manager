package com.smart.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    public String generateToken(String username){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String SECRET_KEY = java.util.Base64.getEncoder().encodeToString(key.getEncoded());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(java.util.Base64.getDecoder().decode(SECRET_KEY)))
                .compact();
    }
}