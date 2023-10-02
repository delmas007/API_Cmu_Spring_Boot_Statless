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
    public ConsultationDto save(String numeroCmu, String examenPhysique,
                                String DiscussionSymptomes, String diagnostic, String ordonnance) {
        return consultationServiceImp.save(numeroCmu,examenPhysique,DiscussionSymptomes,diagnostic,ordonnance);
    }

    @Override
    public ConsultationDto VoirConsultationn(String numero_CMU) {
        return consultationServiceImp.voirConsultation(numero_CMU);
    }
}
