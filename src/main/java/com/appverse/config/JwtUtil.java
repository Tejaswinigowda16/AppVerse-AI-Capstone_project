package com.appverse.config;
 
import java.util.Date;
 
import javax.crypto.SecretKey;
 
import org.springframework.stereotype.Component;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
 
@Component
public class JwtUtil {
 
    private final SecretKey SECRET_KEY =
            Keys.hmacShaKeyFor(
                    "appverseappverseappverseappverse123456".getBytes()
            );
 
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SECRET_KEY)
                .compact();
    }
 
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
 
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
 
 