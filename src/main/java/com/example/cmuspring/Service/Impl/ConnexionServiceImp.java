package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Service.ConnexionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConnexionServiceImp implements ConnexionService {
    JwtEncoder jwtEncoder;
    JwtDecoder jwtDecoder;
    UserDetailsService userDetailsService;
    AuthenticationManager authenticationManager;
//    @Override
//    public ResponseEntity<Map<String, String>> Connexion(String username, String password,
//                                                         boolean withRefreshToken, String refreshToken, String grantType) {
//        String subject=null;
//        String scope=null;
//        if(grantType.equals("password")){
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//            subject=authentication.getName();
//            scope=authentication.getAuthorities()
//                    .stream().map(aut -> aut.getAuthority())
//                    .collect(Collectors.joining(" "));
//
//        } else if(grantType.equals("refreshToken")){
//            if(refreshToken==null) {
//                return new ResponseEntity<>(Map.of("errorMessage","Refresh  Token is required"), HttpStatus.UNAUTHORIZED);
//            }
//            Jwt decodeJWT = null;
//            try {
//                decodeJWT = jwtDecoder.decode(refreshToken);
//            } catch (JwtException e) {
//                return new ResponseEntity<>(Map.of("errorMessage",e.getMessage()), HttpStatus.UNAUTHORIZED);
//            }
//            subject=decodeJWT.getSubject();
//            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
//            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//            scope=authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));
//        }
//        Map<String, String> idToken=new HashMap<>();
//        Instant instant=Instant.now();
//        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
//                .subject(subject)
//                .issuedAt(instant)
//                .expiresAt(instant.plus(withRefreshToken?1:5, ChronoUnit.MINUTES))
//                .issuer("security-service")
//                .claim("scope",scope)
//                .build();
//        String jwtAccessToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
//        idToken.put("accessToken",jwtAccessToken);
//        if(withRefreshToken){
//            JwtClaimsSet jwtClaimsSetRefresh=JwtClaimsSet.builder()
//                    .subject(subject)
//                    .issuedAt(instant)
//                    .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
//                    .issuer("security-service")
//                    .build();
//            String jwtRefreshToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
//            idToken.put("refreshToken",jwtRefreshToken);
//        }
//        return new ResponseEntity<>(idToken,HttpStatus.OK);
//    }
@Override
public ResponseEntity<Map<String, String>> Connexion(String username, String password) {
    String subject=null;
    String scope=null;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        subject=authentication.getName();
        scope=authentication.getAuthorities()
                .stream().map(aut -> aut.getAuthority())
                .collect(Collectors.joining(" "));


    Map<String, String> idToken=new HashMap<>();
    Instant instant=Instant.now();
    JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
            .subject(subject)
            .issuedAt(instant)
            .expiresAt(instant.plus((Duration.ofMinutes(10))))
            .issuer("security-service")
            .claim("scope",scope)
            .build();
    String jwtAccessToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    idToken.put("accessToken",jwtAccessToken);

    return new ResponseEntity<>(idToken,HttpStatus.OK);
}
}
