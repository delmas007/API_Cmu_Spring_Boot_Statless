package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiUtilisateur {

    @PostMapping(value = Api+"/utilisateur/{password}/{nom}/{prenom}/{role}/{numeroCmu}",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@PathVariable String password,@PathVariable String nom,@PathVariable String prenom,
                        @PathVariable String role,@PathVariable String numeroCmu);
}
