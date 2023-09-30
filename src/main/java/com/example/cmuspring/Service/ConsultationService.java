package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import org.springframework.stereotype.Service;

@Service
public interface ConsultationService {

    ConsultationDto save(ConsultationDto dto);

    ConsultationDto voirConsultation(String numero_CMU);
}
