package com.example.demo.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static io.jsonwebtoken.Jwts.builder;

@Service
public class Jwtservice {

    private String SecretKey ="";
    public Jwtservice() {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256"); //algorthim
            SecretKey sk = keygen.generateKey();
            SecretKey = Base64.getEncoder().encodeToString(sk.getEncoded()); //converting to string
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generatedtoken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 *60))
                .and()
                .signWith(getKey())
                .compact();
    }
    private SecretKey getKey()
    {
        byte[] keyBytes= Decoders.BASE64.decode(SecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 🔹 Extract username from token
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 🔹 Extract specific claim
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    // 🔹 Get all claims from token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails)
    {
        final String username = extractUserName(token);
        return (username .equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 🔹 Extract expiration date from token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}


//**********************************************
//
//
//        package com.example.demo.Filter;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class Jwtservice {
//
//    // Fixed secret key (must be at least 32 characters for HS256)
//    private static final String SECRET_KEY =
//            "mysecretkeymysecretkeymysecretkey123456";
//
//    // Generate signing key
//    private SecretKey getKey() {
//        byte[] keyBytes = SECRET_KEY.getBytes();
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    // Generate JWT Token
//    public String generatedtoken(String username) {
//
//        Map<String, Object> claims = new HashMap<>();
//
//        return Jwts.builder()
//                .claims(claims)
//                .subject(username)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
//                .signWith(getKey())
//                .compact();
//    }
//
//    // Extract username from token
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    // Extract specific claim
//    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//
//    // Extract all claims
//    private Claims extractAllClaims(String token) {
//
//        return Jwts.parser()
//                .verifyWith(getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    // Validate token
//    public boolean validateToken(String token, UserDetails userDetails) {
//
//        final String username = extractUserName(token);
//
//        return (username.equals(userDetails.getUsername()) &&
//                !isTokenExpired(token));
//    }
//
//    // Check token expiry
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    // Extract expiration
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }