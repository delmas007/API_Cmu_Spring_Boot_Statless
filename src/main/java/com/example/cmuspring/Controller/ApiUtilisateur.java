package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Dto.UtilisateurDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiUtilisateur {

    @PostMapping(value = Api+"/utilisateur")
    @ApiOperation(value = "Enregistrer un utilisateur", notes = "Cette methode permet cree un utilisateur", response =
            UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree"),
            @ApiResponse(code = 400, message = "L'objet utilisateur n'est pas valide")
    })
    UtilisateurDto save(@RequestParam(required = false) String role,@RequestBody UtilisateurDto dto);


}


