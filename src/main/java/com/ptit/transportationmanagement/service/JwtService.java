package com.ptit.transportationmanagement.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtService {

    private static final String SECRET = "KJFOIE JLDJFIEJLK FJIEJ IE";

    public static String generateToken(Authentication authentication) {
        Date now = new Date();
        String token = Jwts.builder().setSubject(authentication.getName())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 30000000))
                .compact();
        return token;
    }


    public static String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        return username;
    }


}
