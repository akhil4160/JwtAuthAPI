package com.akhil.jwtauthapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import javax.crypto.spec.SecretKeySpec;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                )
                .signWith(
                        new SecretKeySpec(
                                SECRET_KEY.getBytes(),
                                "HmacSHA256"
                        )
                )
                .compact();
    }

    public String extractEmail(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(
                        new javax.crypto.spec.SecretKeySpec(
                                SECRET_KEY.getBytes(),
                                "HmacSHA256"
                        )
                )
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
}