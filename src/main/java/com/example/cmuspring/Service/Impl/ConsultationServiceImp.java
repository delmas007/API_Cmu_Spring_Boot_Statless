package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Service.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@Transactional
public class ConsultationServiceImp implements ConsultationService {
    ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository, DossierPatientServiceImp dossierPatientServiceImp) {
        this.consultationRepository = consultationRepository;
        this.dossierPatientServiceImp = dossierPatientServiceImp;
    }

    DossierPatientServiceImp dossierPatientServiceImp;

    @Override
    public ConsultationDto save(String numeroCmu,ConsultationDto dto) {
        DossierPatientDto dossier = dossierPatientServiceImp.consulterDossierPatient(numeroCmu);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = authentication.getName();
        Consultation donnee = Consultation.builder()
                .examenPhysique(dto.getExamenPhysique())
                .diagnostic(dto.getDiagnostic())
                .discussionDesSymptomes(dto.getDiscussionDesSymptomes())
                .ordonnance(dto.getOrdonnance())
                .idUtilisateur(principal)
                .code(UUID.randomUUID().toString())
                .numeroCmu(DossierPatientDto.toEntity(dossier))
                .build();
        if (dossier.getFeminin()){
            if (dossier.getEnceinte()){
                donnee.setTauxReduction(100);
            }else {
                donnee.setTauxReduction(70);
            }
        }else {
            donnee.setTauxReduction(70);
        }
        return ConsultationDto.fromEntity(consultationRepository.save(donnee));
    }

    @Override
    public ConsultationDto voirConsultation(String numero_CMU) {
        DossierPatientDto dossier = dossierPatientServiceImp.consulterDossierPatient(numero_CMU);
        return consultationRepository.findByNumeroCmu(DossierPatientDto.toEntity(dossier)).map(ConsultationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucune consultation relier a ce numero cmu")
        );
    }


}
