package com.duydangcode.trello_spring.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.duydangcode.trello_spring.dto.TokensDTO;
import com.duydangcode.trello_spring.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class KeyTokenService {
  @Value("${jwt.accessToken.expiration}")
  private long accessTokenExpiration;

  @Value("${jwt.refreshToken.expiration}")
  private long refreshTokenExpiration;

  private String serectKey = new String("aGVsbG93b3JsZHRoaXNpc2FzZWN1cmVrZXlmb3Jqd3Q=");

  public TokensDTO generateTokens(UserModel user) throws InternalError {
    System.out.println(this.refreshTokenExpiration);
    Map<String, Object> claims = new HashMap<>();
    claims.put("username", user.getUsername());
    try {
      String accessToken = Jwts
          .builder()
          .setClaims(claims)
          .setSubject(user.getUsername())
          .signWith(this.signKey())
          .setExpiration(new Date(System.currentTimeMillis() + this.accessTokenExpiration * 1000L))
          .compact();
      String refreshToken = Jwts
          .builder()
          .setClaims(claims)
          .setSubject(user.getUsername())
          .signWith(this.signKey())
          .setExpiration(new Date(System.currentTimeMillis() + this.refreshTokenExpiration * 1000L))
          .compact();
      return new TokensDTO(accessToken, refreshToken);
    } catch (Exception e) {
      System.err.println(e);
      throw new InternalError("Something wrong");
    }
  }

  private Key signKey() {
    byte[] bytes = Decoders.BASE64.decode(this.serectKey);
    return Keys.hmacShaKeyFor(bytes);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(this.signKey())
        .build()
        .parseClaimsJws(token)
        .getBody();

  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = this.extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public boolean checkTokenExpired(String token) {
    Date expirationDate = this.extractClaim(token, Claims::getExpiration);
    return expirationDate.before(new Date());
  }

}
