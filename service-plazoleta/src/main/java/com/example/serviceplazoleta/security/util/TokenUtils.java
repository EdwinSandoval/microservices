package com.example.serviceplazoleta.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class TokenUtils {
    private  static final String ACCESS_TOKEN_SECRET="597133743677397A24432646294A404E635266556A586E327234753778214125";
    private static final Long ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000l;
//    public static String createToken(String nombre, String email, List<String> roles){
//        long expirationTime=ACCESS_TOKEN_VALIDITY_SECONDS*1_000;
//        Date expirationDate=new Date(System.currentTimeMillis()*expirationTime);
//
//        Map<String,Object> extra=new HashMap<>();
//        extra.put("nombre",nombre);
//        extra.put("roles",roles);
//
//        return Jwts
//                .builder()
//                .setSubject(email)
//                .setExpiration(expirationDate)
//                .addClaims(extra)
//                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
//                .compact();
//    }
    public static String createToken(String nombre, String email){
        long expirationTime=ACCESS_TOKEN_VALIDITY_SECONDS*1_000;
        Date expirationDate=new Date(System.currentTimeMillis()+expirationTime);

        Map<String,Object> extra=new HashMap<>();
        extra.put("nombre",nombre);
//        extra.put("roles",roles);

        return Jwts
                .builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

//    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
//        try {
//            Claims claims=Jwts
//                    .parserBuilder()
//                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//            String email=claims.getSubject();
//            List<String> roles=claims.get("roles", ArrayList.class);
//            return new UsernamePasswordAuthenticationToken(
//                    email,
//                    null,
//                    roles.stream().map(r->new SimpleGrantedAuthority(r)).collect(Collectors.toList())
//            );
//        }
//        catch (Exception e){
//            return null;
//        }
//    }
    public static UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        try {
            Claims claims=Jwts
                    .parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email=claims.getSubject();
//            List<String> roles=claims.get("roles", ArrayList.class);
            return new UsernamePasswordAuthenticationToken(
                    email,
                    null,
                    Collections.emptyList());

        }
        catch (Exception e){
            return null;
        }
    }
}
