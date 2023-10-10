package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.DossierPatient;
import org.springframework.stereotype.Service;


public interface DossierPatientService {

    DossierPatientDto ajouerDossierPatient(DossierPatientDto dossierPatientDto);

    DossierPatientDto consulterDossierPatient(String numeroCmu);

    DossierPatientDto modifierDossierPatient(DossierPatientDto dossierPatientDto);

    void supprimerDossierPatient(String numeroCmu);

}
