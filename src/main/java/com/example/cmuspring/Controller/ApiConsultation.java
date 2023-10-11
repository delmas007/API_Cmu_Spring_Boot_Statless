package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiConsultation {

    @PostMapping(value = Api+"/consultation")
    ConsultationDto save (String numeroCmu,@RequestBody ConsultationDto dto);


    @GetMapping(value = Api+"/voirConsultation")
    ConsultationDto VoirConsultationn(@RequestParam(required = false) String numero_CMU);

//    @GetMapping(value = Api+"/voirConsultation{numero_CMU}")
//    ConsultationDto VoirConsultationn(@PathVariable String numero_CMU);


}
