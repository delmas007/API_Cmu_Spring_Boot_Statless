package com.example.cmuspring.Controller.Impl;

import com.example.cmuspring.Controller.ApiConnexion;
import com.example.cmuspring.Service.Impl.ConnexionServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ConnexionController implements ApiConnexion {
    ConnexionServiceImp connexionServiceImp;

    @Override
    public ResponseEntity<Map<String, String>> Connexion(String username, String password,boolean withRefreshToken,
                                         String refreshToken,String grantType ) {
        return connexionServiceImp.Connexion(username,password,withRefreshToken,refreshToken,grantType);
    }
}
