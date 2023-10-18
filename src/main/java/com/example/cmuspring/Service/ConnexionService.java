package com.example.cmuspring.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ConnexionService {
    ResponseEntity<Map<String, String>> Connexion(String username,String password, boolean withRefreshToken,
                                                  String refreshToken, String grantType);
}
