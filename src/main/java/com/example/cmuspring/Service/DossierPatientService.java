package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.DossierPatient;
import org.springframework.stereotype.Service;


public interface DossierPatientService {

    DossierPatientDto ajouerDossierPatient(String id,String ville,
                                           int age,boolean masculin,boolean feminin,boolean enceinte);

    DossierPatientDto consulterDossierPatient(String numeroCmu);

    DossierPatientDto modifierDossierPatient(String numeroCmu,String antecedentsMedicaux,String historiqueVaccination,String resumesMedicaux);

    int supprimerDossierPatient(String numeroCmu);

}
