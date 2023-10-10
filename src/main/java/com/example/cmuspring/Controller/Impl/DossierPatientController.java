package com.example.cmuspring.Controller.Impl;

import com.example.cmuspring.Controller.ApiDossierPatient;
import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Service.Impl.DossierPatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DossierPatientController implements ApiDossierPatient {
    DossierPatientServiceImp dossierPatientServiceImp;
    @Autowired
    public DossierPatientController(DossierPatientServiceImp dossierPatientServiceImp) {
        this.dossierPatientServiceImp = dossierPatientServiceImp;
    }


    @Override
    public DossierPatientDto ajouerDossierPatient(DossierPatientDto dto) {
        return dossierPatientServiceImp.ajouerDossierPatient(dto);
    }

    @Override
    public DossierPatientDto consulterDossierPatient(String numeroCmu) {
        return dossierPatientServiceImp.consulterDossierPatient(numeroCmu);
    }

    @Override
    public DossierPatientDto modifierDossierPatient(DossierPatientDto dto) {
        return dossierPatientServiceImp.modifierDossierPatient(dto);
    }

    @Override
    public void supprimerDossierPatient(String numeroCmu) {
        dossierPatientServiceImp.supprimerDossierPatient(numeroCmu);
    }
}
