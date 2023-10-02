package com.example.cmuspring.Repository;

import com.example.cmuspring.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {
    Optional<Utilisateur> findById(String id);
}
