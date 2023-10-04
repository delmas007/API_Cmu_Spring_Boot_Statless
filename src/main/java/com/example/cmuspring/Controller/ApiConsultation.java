package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiConsultation {

    @PostMapping(value = Api+"/consultation")
    ConsultationDto save (@RequestParam(required = false) String numeroCmu, @RequestParam(required = false) String examenPhysique
            , @RequestParam(required = false) String DiscussionSymptomes, @RequestParam(required = false)String diagnostic, @RequestParam(required = false) String ordonnance);


    @GetMapping(value = Api+"/voirConsultation")
    ConsultationDto VoirConsultationn(@RequestParam(required = false) String numero_CMU);
}
