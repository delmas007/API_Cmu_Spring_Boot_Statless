package com.example.cmuspring.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiConnexion {

    @PostMapping(Api+"/connexion")
    Map<String, String> Connexion(@RequestParam(required = false) String username,
                                                         @RequestParam(required = false) String password);
}
