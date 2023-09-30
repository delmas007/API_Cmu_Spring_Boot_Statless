package com.example.cmuspring.Dto;

import com.example.cmuspring.Model.DossierPatient;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DossierPatientDto {

    private String numeroCmu;

    private String ville;

    private String antecedentMedicaux;

    private String historiqueDeVaccination;

    private String resumesMedicaux;

    private int age;

    private Boolean masculin;

    private Boolean feminin;

    private Boolean enceinte;

    private String idUtilisateur;

    public static DossierPatientDto fromEntity(DossierPatient dossierPatient){
        if (dossierPatient == null){
            return null;
        }
        return DossierPatientDto.builder()
                .numeroCmu(dossierPatient.getNumeroCmu())
                .ville(dossierPatient.getVille())
                .antecedentMedicaux(dossierPatient.getAntecedentMedicaux())
                .historiqueDeVaccination(dossierPatient.getHistoriqueDeVaccination())
                .resumesMedicaux(dossierPatient.getResumesMedicaux())
                .age(dossierPatient.getAge())
                .masculin(dossierPatient.getMasculin())
                .feminin(dossierPatient.getFeminin())
                .enceinte(dossierPatient.getEnceinte())
                .idUtilisateur(dossierPatient.getIdUtilisateur())
                .build();
    }
    
    public static DossierPatient toEntity(DossierPatientDto dossierPatientDto){
        if (dossierPatientDto == null){
            return null;
        }
        return DossierPatient.builder()
                .numeroCmu(dossierPatientDto.getNumeroCmu())
                .ville(dossierPatientDto.getVille())
                .antecedentMedicaux(dossierPatientDto.getAntecedentMedicaux())
                .historiqueDeVaccination(dossierPatientDto.getHistoriqueDeVaccination())
                .resumesMedicaux(dossierPatientDto.getResumesMedicaux())
                .age(dossierPatientDto.getAge())
                .masculin(dossierPatientDto.getMasculin())
                .feminin(dossierPatientDto.getFeminin())
                .enceinte(dossierPatientDto.getEnceinte())
                .idUtilisateur(dossierPatientDto.getIdUtilisateur())
                .build();
    }
}
