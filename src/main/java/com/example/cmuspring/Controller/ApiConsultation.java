package com.example.cmuspring.Controller;

import com.example.cmuspring.Dto.ConsultationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.cmuspring.Utils.Constants.Api;

public interface ApiConsultation {

    @PostMapping(value = Api+"/consultation/{numeroCmu}/{examenPhysique}/{DiscussionSymptomes}/{diagnostic}/{ordonnance}"
            ,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto save (@PathVariable("numeroCmu") String numeroCmu,@PathVariable("examenPhysique") String examenPhysique
            ,@PathVariable("DiscussionSymptomes") String DiscussionSymptomes, @PathVariable("diagnostic")String diagnostic,@PathVariable("ordonnance") String ordonnance);


    @GetMapping(value = Api+"voirConsultation/{numero_CMU}",produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto VoirConsultationn(@PathVariable("numero_CMU") String numero_CMU);
}
