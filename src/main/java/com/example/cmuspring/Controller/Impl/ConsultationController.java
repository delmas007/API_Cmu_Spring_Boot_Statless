package com.example.cmuspring.Controller.Impl;

import com.example.cmuspring.Controller.ApiConsultation;
import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Service.Impl.ConsultationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultationController implements ApiConsultation {

    ConsultationServiceImp consultationServiceImp;

    @Autowired
    public ConsultationController(ConsultationServiceImp consultationServiceImp) {
        this.consultationServiceImp = consultationServiceImp;
    }


    @Override
    public ConsultationDto save(ConsultationDto dto) {
        return consultationServiceImp.save(dto);
    }

    @Override
    public ConsultationDto VoirConsultationn(String numero_CMU) {
        return consultationServiceImp.voirConsultation(numero_CMU);
    }
}
