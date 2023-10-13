package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

@io.swagger.annotations.Api(Api+"/Consultation")
public interface ApiConsultation {

    @PostMapping(value = Api+"/consultation")
    @ApiOperation(value = "Enregistrer une consultation", notes = "Cette methode permet d'enregistrer  une consultation", response =
            ConsultationDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet consultation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet consultation n'est pas valide")
    })
    ConsultationDto save (String numeroCmu,@RequestBody ConsultationDto dto);


    @GetMapping(value = Api+"/voirConsultation")
    @ApiOperation(value = "Voir une consultation", notes = "Cette methode permet de voir sa consultation", response =
            ConsultationDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la consultation a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune consultation n'existe dans la BDD avec le numero CMU fourni")
    })
    ConsultationDto VoirConsultationn(@RequestParam(required = false) String numero_CMU);

//    @GetMapping(value = Api+"/voirConsultation{numero_CMU}")
//    ConsultationDto VoirConsultationn(@PathVariable String numero_CMU);


}
