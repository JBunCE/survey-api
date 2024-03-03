package org.example.surveyapi.application.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.example.surveyapi.infraestructure.configurations.jwt.JwtConfig;
import org.example.surveyapi.infraestructure.configurations.security.user.UserDetailsImpl;
import org.example.surveyapi.infraestructure.configurations.security.user.UserDetailsServiceImpl;
import org.example.surveyapi.domain.models.responses.BaseResponse;
import org.example.surveyapi.domain.models.responses.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class JwtService {

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private SecretKey secretKey;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public BaseResponse userTokenRefresh(String refreshToken) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(refreshToken)
                .getBody();
        String email = claims.getSubject();

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);

        Date expirationDate = Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpiration()));
        String token = Jwts.builder()
                .setSubject(userDetails.getName())
                .claim("authorities", userDetails.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(expirationDate)
                .signWith(secretKey).compact();

        Date refreshExpirationDate = Date.valueOf(LocalDate.now().plusDays(jwtConfig.getRefreshTokenExpiration()));
        String newRefreshToken = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new java.util.Date())
                .setExpiration(refreshExpirationDate)
                .signWith(secretKey).compact();

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setAccessToken(token);
        jwtResponse.setRefreshToken(newRefreshToken);

        return BaseResponse.builder()
                .data(jwtResponse)
                .message("Successfully authenticated")
                .success(Boolean.TRUE)
                .status(HttpStatus.OK)
                .statusCode(200).build();
    }
}
