package com.cybersport.tournament_backend.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Key key = Keys.hmacShaKeyFor("очень_секретный_ключ_32+_символа".getBytes());

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject(); // здесь лежит email
    }

    public String generateToken(String email) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + 1000 * 60 * 60); // 1 час

        return Jwts.builder()
                .setSubject(email)      // здесь говорим: sub = email
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
