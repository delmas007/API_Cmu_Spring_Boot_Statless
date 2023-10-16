package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Exception.ErrorCodes;
import com.example.cmuspring.Exception.InvalidEntityException;
import com.example.cmuspring.Exception.EntityNotFoundException;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Service.ConsultationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;


import static com.example.cmuspring.Validator.ConsultationValidator.consultation;

@Service
@Transactional
@Slf4j
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

        if(!StringUtils.hasLength(numeroCmu)){
            throw new EntityNotFoundException("numero cmu vide",ErrorCodes.CONSULTATION_PAS_VALIDE);
        }
        DossierPatientDto dossier = dossierPatientServiceImp.consulterDossierPatient(numeroCmu);
        Consultation voir = consultationRepository.findByNumeroCmu(numeroCmu).orElse(null);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String principal = authentication.getName();
        if (voir != null){
            voir.setExamenPhysique(dto.getExamenPhysique());
            voir.setDiagnostic(dto.getDiagnostic());
            voir.setDiscussionDesSymptomes(dto.getDiscussionDesSymptomes());
            voir.setOrdonnance(dto.getOrdonnance());
            voir.setIdUtilisateur(principal);
            voir.setCode(UUID.randomUUID().toString());
            voir.setNumeroCmu(DossierPatientDto.toEntity(dossier));
            if (dossier.getFeminin()){
                if (dossier.getEnceinte()){
                    voir.setTauxReduction(100);
                }else {
                    voir.setTauxReduction(70);
                }
            }else {
                voir.setTauxReduction(70);
            }
            return ConsultationDto.fromEntity(consultationRepository.save(voir));
        }else {
            Consultation donnee = Consultation.builder()
                    .examenPhysique(dto.getExamenPhysique())
                    .diagnostic(dto.getDiagnostic())
                    .discussionDesSymptomes(dto.getDiscussionDesSymptomes())
                    .ordonnance(dto.getOrdonnance())
                    .idUtilisateur(principal)
                    .code(UUID.randomUUID().toString())
                    .numeroCmu(DossierPatientDto.toEntity(dossier))
                    .build();
            if (dossier.getFeminin()) {
                if (dossier.getEnceinte()) {
                    donnee.setTauxReduction(100);
                } else {
                    donnee.setTauxReduction(70);
                }
            } else {
                donnee.setTauxReduction(70);
            }
            return ConsultationDto.fromEntity(consultationRepository.save(donnee));
        }

    }

    @Override
    public ConsultationDto voirConsultation(String numero_CMU) {
        String num = consultation(numero_CMU);
        if(!StringUtils.hasLength(num)){
            log.error(num);
        }
        DossierPatientDto dossier = dossierPatientServiceImp.consulterDossierPatient(numero_CMU);
        return consultationRepository.findByNumeroCmu(DossierPatientDto.toEntity(dossier)).map(ConsultationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune consultation lier au numero cmu",ErrorCodes.CONSULTATION_PAS_TROUVER)
        );
    }



}
