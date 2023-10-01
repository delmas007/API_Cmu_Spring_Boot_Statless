package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Service.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ConsultationServiceImp implements ConsultationService {
    ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public ConsultationDto save(ConsultationDto dto) {
        Consultation donnee = ConsultationDto.toEntity(dto);
        return ConsultationDto.fromEntity(consultationRepository.save(donnee));
    }

    @Override
    public ConsultationDto voirConsultation(String numero_CMU) {
        return consultationRepository.findConsultationByNumeroCmu(numero_CMU).map(ConsultationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                "Aucune consultation relier a ce numero cmu")
        );
    }


}
