package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Model.Role;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Repository.UtilisateurRepository;
import com.example.cmuspring.Service.UtilisateurService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UtilisateurServiceImp implements UtilisateurService {


    UtilisateurRepository utilisateurRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UtilisateurDto loadUserById(String id) {
        Optional<Utilisateur> donnee = utilisateurRepository.findById(id);
        return UtilisateurDto.fromEntity(donnee.orElse(null));
    }

    @Override
    public UtilisateurDto save(String role,UtilisateurDto dto) {
        UtilisateurDto utilisateurDto = UtilisateurDto.builder()
                .id(UUID.randomUUID().toString())
                .password(passwordEncoder.encode(dto.getPassword()))
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .role(Role.builder().role(role.toUpperCase()).build())
                .numeroCmu(dto.getNumeroCmu())
                .build();
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));
    }


//    @Override
//    public Utilisateur loadUserById(String id) {
//        Optional<Utilisateur> donnee = utilisateurRepository.findById(id);
//        return donnee.orElseThrow(() -> new EntityNotFoundException(id));
//    }
}
