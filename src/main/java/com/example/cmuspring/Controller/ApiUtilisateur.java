package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.UtilisateurDto;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiUtilisateur {

    @PostMapping(value = "/utilisation/",produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@PathParam("password") String password, @PathParam("nom") String nom, @PathParam("prenom") String prenom,
                        @PathParam("role") String role, @PathParam("numeroCmu") String numeroCmu);

    @GetMapping(value = "/a/",produces = MediaType.APPLICATION_JSON_VALUE)
    String a(@PathParam("password") String password);
}


