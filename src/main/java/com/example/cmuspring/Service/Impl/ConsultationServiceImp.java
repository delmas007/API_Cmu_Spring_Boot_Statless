package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Service.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ConsultationServiceImp implements ConsultationService {
    ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public ConsultationDto save(String numeroCmu, String examenPhysique, String DiscussionSymptomes,
                                String diagnostic, String ordonnance) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        Consultation donnee = Consultation.builder()
                .examenPhysique(examenPhysique)
                .diagnostic(diagnostic)
                .discussionDesSymptomes(DiscussionSymptomes)
                .ordonnance(ordonnance)
                .idUtilisateur(principal.getName())
                .code(UUID.randomUUID().toString())
                .build();
        if (donnee.getNumeroCmu().getFeminin()){
            if (donnee.getNumeroCmu().getEnceinte()){
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
        return consultationRepository.findByNumeroCmu(numero_CMU).map(ConsultationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucune consultation relier a ce numero cmu")
        );
    }


}
