//package com.example.addressbook.security.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private long jwtExpirationInMs;
//
//    public String generateToken(UserDetails userDetails, Map<String, Object> extraClaims) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
//
//        return Jwts.builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser() // Use Jwts.parser() instead of Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .parseClaimsJws(token) // Correct method call
//                .getBody();
//    }
//
//    private Key getSigningKey() {
//        return Keys.hmacShaKeyFor(secret.getBytes());
//    }
//
//    public boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//    public boolean validateToken(String token, String username) {
//        final String extractedUsername = getUsernameFromToken(token);
//        return (extractedUsername.equals(username) && !isTokenExpired(token));
//    }
//}
