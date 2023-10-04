package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.DossierPatient;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Repository.DossierConsultationRepository;
import com.example.cmuspring.Service.DossierPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class DossierPatientServiceImp implements DossierPatientService {

    DossierConsultationRepository dossierConsultationRepository;

    @Autowired
    public DossierPatientServiceImp(DossierConsultationRepository dossierConsultationRepository) {
        this.dossierConsultationRepository = dossierConsultationRepository;
    }

    @Override
    public DossierPatientDto ajouerDossierPatient(String id,String ville
            , int age, boolean masculin, boolean feminin, boolean enceinte) {
        String numCmu = UUID.randomUUID().toString();
        DossierPatient donnee = DossierPatient.builder()
                .numeroCmu(numCmu)
                .ville(ville)
                .age(age)
                .masculin(masculin)
                .feminin(feminin)
                .enceinte(enceinte)
                .idUtilisateur(Utilisateur.builder().id(id).build())
                .build();

        return DossierPatientDto.fromEntity(dossierConsultationRepository.save(donnee));
    }


    @Override
    public DossierPatientDto consulterDossierPatient(String numeroCmu) {

//        return dossierConsultationRepository.findByNumeroCmu(numeroCmu)
//                .map(DossierPatientDto::fromEntity)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "Aucun Dossier n'est relier a ce numero cmu")
//                );
        return DossierPatientDto.fromEntity(dossierConsultationRepository.findByNumeroCmu(numeroCmu));
    }

    @Override
    public DossierPatientDto modifierDossierPatient(String numeroCmu, String antecedentsMedicaux,
                                                    String historiqueVaccination, String resumesMedicaux) {
        DossierPatient donnee = dossierConsultationRepository.findByNumeroCmu(numeroCmu);
        donnee.setAntecedentMedicaux(antecedentsMedicaux);
        donnee.setHistoriqueDeVaccination(historiqueVaccination);
        donnee.setResumesMedicaux(resumesMedicaux);
        return DossierPatientDto.fromEntity(dossierConsultationRepository.save(donnee));
    }


    @Override
    public void supprimerDossierPatient(String numeroCmu) {
        dossierConsultationRepository.deleteById(numeroCmu);
    }
}
