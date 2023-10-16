package com.example.cmuspring.Controller.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ConnexionController implements  ApiConnexion{

    AuthenticationManager authenticationManager;
    @Override
    public Void Connexion(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );
        return null;
    }
}
