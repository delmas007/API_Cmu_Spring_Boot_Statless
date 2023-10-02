package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.DossierPatientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiDossierPatient {

    @PostMapping(value = Api+"/creeDossier/{id}/{ville}/{age}/{masculin}/{feminin}/{enceinte}"
            ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    DossierPatientDto ajouerDossierPatient(@PathVariable String id,@PathVariable("ville") String ville,
                                           @PathVariable int age,@PathVariable boolean masculin
                                            ,@PathVariable boolean feminin,@PathVariable boolean enceinte);

    @GetMapping(value = Api+"/consulter/{numeroCmu}",produces = MediaType.APPLICATION_JSON_VALUE)
    DossierPatientDto consulterDossierPatient(@PathVariable String numeroCmu);

    @GetMapping(value = Api+"/modifier/{numeroCmu}/{antecedentsMedicaux}/{historiqueVaccination}/{resumesMedicaux}"
                ,produces = MediaType.APPLICATION_JSON_VALUE)
    DossierPatientDto modifierDossierPatient(@PathVariable String numeroCmu,@PathVariable String antecedentsMedicaux,
                                             @PathVariable String historiqueVaccination,@PathVariable String resumesMedicaux);

    @DeleteMapping(value = Api+"/supprimer/{numeroCmu}")
    void supprimerDossierPatient(@PathVariable String numeroCmu);
}
