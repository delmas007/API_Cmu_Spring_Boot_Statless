package com.example.cmuspring.Validator;

import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> utilisateurValidator(String role,UtilisateurDto dto){

        List<String> donne = new ArrayList<>();
        if(dto == null){
            donne.add("Veillez renseigner le mot de passe");
            donne.add("Veillez renseigner le nom");
            donne.add("Veillez renseigner le prenom");
            return donne;
        }
        if(!StringUtils.hasLength(dto.getPassword())){
            donne.add("Veillez renseigner le mot de passe");
        }
        if(!StringUtils.hasLength(dto.getNom())){
            donne.add("Veillez renseigner le nom");
        }
        if(!StringUtils.hasLength(role)){
            donne.add("Veillez renseigner le role");
        }
        return donne;
    }
}
