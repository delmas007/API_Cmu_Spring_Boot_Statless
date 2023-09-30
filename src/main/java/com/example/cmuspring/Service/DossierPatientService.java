package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.DossierPatient;
import org.springframework.stereotype.Service;

@Service
public interface DossierPatientService {

    DossierPatientDto ajouerDossierPatient(DossierPatientDto dto);

    DossierPatientDto consulterDossierPatient(DossierPatientDto dto);

    DossierPatientDto modifierDossierPatient(String numeroCmu);

    void supprimerDossierPatient(String numeroCmu);

}
