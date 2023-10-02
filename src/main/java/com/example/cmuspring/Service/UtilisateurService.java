package com.example.cmuspring.Service;

import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Model.Utilisateur;

import java.util.Optional;

public interface UtilisateurService {

    UtilisateurDto loadUserById(String id);

    UtilisateurDto save(UtilisateurDto dto);
}
