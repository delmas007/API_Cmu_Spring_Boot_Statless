package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Repository.UtilisateurRepository;
import com.example.cmuspring.Service.UtilisateurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
    @Autowired
    public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto loadUserById(String id) {
        Optional<Utilisateur> donnee = utilisateurRepository.findById(id);
        return UtilisateurDto.fromEntity(donnee.orElse(null));
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

//    @Override
//    public Utilisateur loadUserById(String id) {
//        Optional<Utilisateur> donnee = utilisateurRepository.findById(id);
//        return donnee.orElseThrow(() -> new EntityNotFoundException(id));
//    }
}
