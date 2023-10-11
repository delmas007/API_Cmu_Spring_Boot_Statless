package com.example.cmuspring.Validator;

import com.example.cmuspring.Dto.DossierPatientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DossierPatientValidator {

    public static List<String> dossierPatientValidatorModifier(DossierPatientDto dto){

        List<String> donne = new ArrayList<>();
        if(dto == null){
            donne.add("Veillez renseigner le numeroCmu");
            donne.add("Veillez renseigner l'antecedent Medical");
            donne.add("Veillez renseigner l'historique De Vaccination");
            donne.add("Veillez renseigner le resume Medical");
            return donne;
        }
        if(!StringUtils.hasLength(dto.getNumeroCmu())){
            donne.add("Veillez renseigner le numeroCmu");
        }
        if(!StringUtils.hasLength(dto.getHistoriqueDeVaccination())){
            donne.add("Veillez renseigner l'historique De Vaccination");
        }
        if(!StringUtils.hasLength(dto.getAntecedentMedicaux())){
            donne.add("Veillez renseigner l'antecedent Medical");
        }
        if(!StringUtils.hasLength(dto.getResumesMedicaux())){
            donne.add("Veillez renseigner le resume Medical");
        }
        return donne;
    }
    public static List<String> dossierPatientValidatorAjouter(DossierPatientDto dto){

        List<String> donne = new ArrayList<>();
        if(dto == null){
            donne.add("Veillez renseigner la ville");
            donne.add("Veillez renseigner l'age");
            donne.add("Veillez renseigner le sexe et l'etat");
            return donne;
        }
        if(!StringUtils.hasLength(dto.getVille())){
            donne.add("Veillez renseigner la ville");
        }
        if(dto.getFeminin() == null && dto.getMasculin() == null && dto.getEnceinte() == null){
            donne.add("Veillez renseigner le sexe et l'etat");
        }
        return donne;
    }
    public static String dossierPatientValidatorId(String id){
        String a = null;
        if(!StringUtils.hasLength(id)){
            a=("Veillez renseigner l'identifiant");
        }
        return a;
    }
    public static String dossierPatientValidatorConsulter(String numeroCmu){
        String a = null;
        if(!StringUtils.hasLength(numeroCmu)){
            a=("Veillez renseigner le numero Cmu");
        }
        return a;
    }
    public static String dossierPatientValidatorSupprimer(String numeroCmu){
        String a = null;
        if(!StringUtils.hasLength(numeroCmu)){
            a=("Veillez renseigner le numero Cmu");
        }
        return a;
    }


}
