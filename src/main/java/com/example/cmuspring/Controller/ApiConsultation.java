package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import org.springframework.web.bind.annotation.*;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiConsultation {

    @PostMapping(value = Api+"/consultation")
    ConsultationDto save (@RequestParam(required = false) String numeroCmu, @RequestParam(required = false) String examenPhysique
            , @RequestParam(required = false) String DiscussionSymptomes, @RequestParam(required = false)String diagnostic, @RequestParam(required = false) String ordonnance);


    @GetMapping(value = Api+"/voirConsultation")
    ConsultationDto VoirConsultationn(@RequestParam(required = false) String numero_CMU);

//    @GetMapping(value = Api+"/voirConsultation{numero_CMU}")
//    ConsultationDto VoirConsultationn(@PathVariable String numero_CMU);


}
