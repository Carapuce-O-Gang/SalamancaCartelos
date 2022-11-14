package carapuceogang.salamancacartelos.authservice.security;

import carapuceogang.salamancacartelos.authservice.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${authservice.app.jwtSecret}")
    private String jwtSecret;

    @Value("${authservice.app.jwtExpiration}")
    private String jwtExpiration;
    
    public String createJwt(UserProfile profile) {
        Date currentDate = new Date();

        return Jwts.builder()
            .setSubject(profile.getUsername())
            .setIssuedAt(currentDate)
            .setExpiration(new Date(currentDate.getTime() + jwtExpiration))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }

    public String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public boolean validateJwt(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromJwt(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
}
