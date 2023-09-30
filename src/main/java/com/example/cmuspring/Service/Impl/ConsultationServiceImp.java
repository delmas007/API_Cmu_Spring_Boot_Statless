package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ConsultationDto voirConsultation(ConsultationDto dto) {
        return null;
    }
}
