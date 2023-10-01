package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.DossierPatient;
import com.example.cmuspring.Repository.DossierConsultationRepository;
import com.example.cmuspring.Service.DossierPatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DossierPatientServiceImp implements DossierPatientService {

    DossierConsultationRepository dossierConsultationRepository;

    @Autowired
    public DossierPatientServiceImp(DossierConsultationRepository dossierConsultationRepository) {
        this.dossierConsultationRepository = dossierConsultationRepository;
    }

    @Override
    public DossierPatientDto ajouerDossierPatient(DossierPatientDto dto) {
        DossierPatient donnee = DossierPatientDto.toEntity(dto);
        return DossierPatientDto.fromEntity(dossierConsultationRepository.save(donnee));
    }

    @Override
    public DossierPatientDto consulterDossierPatient(String numeroCmu) {

        return dossierConsultationRepository.findDossierPatientByNumeroCmu(numeroCmu)
                .map(DossierPatientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun Dossier n'est relier a ce numero cmu")
                );
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
