package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Dto.DossierPatientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

@io.swagger.annotations.Api(Api+"/DossierPatient")
public interface ApiDossierPatient {

//    @PostMapping(value = Api+"/creeDossier")
//    DossierPatientDto ajouerDossierPatient(@RequestParam(required = false) String id, @RequestParam(required = false) String ville,
//                                           @RequestParam(required = false) int age, @RequestParam(required = false) boolean masculin
//                                            , @RequestParam(required = false) boolean feminin, @RequestParam(required = false) boolean enceinte);

    @PostMapping(value = Api+"/creeDossier")
    @ApiOperation(value = "Enregistrer un dossier patient", notes = "Cette methode permet d'enregistrer un dossier patient", response =
            DossierPatientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet dossier patient cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet dossier patient n'est pas valide")
    })
    DossierPatientDto ajouerDossierPatient(@RequestParam String id,@RequestBody DossierPatientDto dto);

    @GetMapping(value = Api+"/consulter")
    @ApiOperation(value = "Voir un dossier patient", notes = "Cette methode permet de voir son dossier patient", response =
            DossierPatientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le dossier patient a ete trouver dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun dossier patient n'existe dans la BDD avec le numero CMU fourni")
    })
    DossierPatientDto consulterDossierPatient(@RequestParam(required = false) String numeroCmu);

//    @PutMapping(value = Api+"/modifier")
//    DossierPatientDto modifierDossierPatient(@RequestParam(required = false) String numeroCmu,@RequestParam(required = false) String antecedentsMedicaux,
//                                             @RequestParam(required = false) String historiqueVaccination,@RequestParam(required = false) String resumesMedicaux);
    @PutMapping(value = Api+"/modifier")
    @ApiOperation(value = "Modifier un dossier patient", notes = "Cette methode permet modifier un dossier patient", response =
            DossierPatientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet dossier patient modifier"),
            @ApiResponse(code = 400, message = "L'objet dossier patient n'est pas valide")
    })
    DossierPatientDto modifierDossierPatient(@RequestBody DossierPatientDto dto);

    @DeleteMapping(value = Api+"/supprimer")
    @ApiOperation(value = "Supprimer un dossier patient", notes = "Cette methode permet de supprimer un dossier patient par le numero CMU")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le dossier patient a ete supprime")
    })
    void supprimerDossierPatient(@RequestParam(required = false) String numeroCmu);
}
