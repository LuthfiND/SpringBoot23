package id.sinaukoding23.latihan.config;

import id.sinaukoding23.latihan.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final long JWT_TOKEN_VALIDITY = 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String doGenerateToken(String username){
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims).setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token){
        final Claims claims = Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public Boolean validationToken(String token, User user){
        String username = getUsernameFromToken(token);

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        Boolean isTokenExpired = claims.getExpiration().before(new Date(System.currentTimeMillis()));

        return (username.equals(user.getUsername()) && !isTokenExpired);
    }
}