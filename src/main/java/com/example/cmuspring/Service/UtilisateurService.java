package com.example.cmuspring.Service;

import com.example.cmuspring.Model.Utilisateur;

import java.util.Optional;

public interface UtilisateurService {

    Utilisateur loadUserById(String id);
}
