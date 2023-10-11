package com.example.cmuspring.Validator;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Dto.DossierPatientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConsultationValidator {
        public static String consultation(String numeroCmu){
            String a = null;
            if (!StringUtils.hasLength(numeroCmu)) {
                a = ("Veillez renseigner le numero Cmu");
            }
            return a;
        }

}