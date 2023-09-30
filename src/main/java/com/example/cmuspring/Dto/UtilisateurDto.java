package com.example.cmuspring.Dto;

import com.example.cmuspring.Model.Utilisateur;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {

    private String id;

    private String password;

    private String nom;

    private String prenom;

    private String role;
    
    private String numeroCmu;
    
    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .password(utilisateur.getPassword())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .role(utilisateur.getRole())
                .numeroCmu(utilisateur.getNumeroCmu())
                .build();
    }
    
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
        }
        return Utilisateur.builder()
                .id(utilisateurDto.getId())
                .password(utilisateurDto.getPassword())
                .nom(utilisateurDto.getNom())
                .prenom(utilisateurDto.getPrenom())
                .role(utilisateurDto.getRole())
                .numeroCmu(utilisateurDto.getNumeroCmu())
                .build();
    }
}
