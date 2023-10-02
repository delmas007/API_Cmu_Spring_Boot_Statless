package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Repository.ConsultationRepository;
import org.springframework.stereotype.Service;

public interface ConsultationService {

    ConsultationDto save(String numeroCmu,String examenPhysique,String DiscussionSymptomes
            ,String diagnostic,String ordonnance);

    ConsultationDto voirConsultation(String numero_CMU);
}
