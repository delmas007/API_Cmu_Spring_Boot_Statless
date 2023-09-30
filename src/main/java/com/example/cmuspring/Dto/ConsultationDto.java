package com.example.cmuspring.Dto;


import com.example.cmuspring.Model.Consultation;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConsultationDto {

    private Integer id;

    private String examenPhysique;

    private String discussionDesSymptomes;

    private String diagnostic;

    private String ordonnance;

    private int tauxReduction;

    private String code;

    private String numeroCmu;

    private String idUtilisateur;

    public static ConsultationDto fromEntity(Consultation consultation){
        if(consultation == null){
            return  null;
        }
        return ConsultationDto.builder()
                .id(consultation.getId())
                .examenPhysique(consultation.getExamenPhysique())
                .discussionDesSymptomes(consultation.getDiscussionDesSymptomes())
                .diagnostic(consultation.getDiagnostic())
                .ordonnance(consultation.getOrdonnance())
                .tauxReduction(consultation.getTauxReduction())
                .code(consultation.getCode())
                .numeroCmu(consultation.getNumeroCmu())
                .idUtilisateur(consultation.getIdUtilisateur())
                .build();
    }

    public static Consultation toEntity(ConsultationDto consultationDto){
        if(consultationDto == null){
            return  null;
        }
        return Consultation.builder()
                .id(consultationDto.getId())
                .examenPhysique(consultationDto.getExamenPhysique())
                .discussionDesSymptomes(consultationDto.getDiscussionDesSymptomes())
                .diagnostic(consultationDto.getDiagnostic())
                .ordonnance(consultationDto.getOrdonnance())
                .tauxReduction(consultationDto.getTauxReduction())
                .code(consultationDto.getCode())
                .numeroCmu(consultationDto.getNumeroCmu())
                .idUtilisateur(consultationDto.getIdUtilisateur())
                .build();
    }
}
