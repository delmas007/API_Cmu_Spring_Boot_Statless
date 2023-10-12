package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Exception.EntityNotFoundException;
import com.example.cmuspring.Exception.ErrorCodes;
import com.example.cmuspring.Exception.InvalidEntityException;
import com.example.cmuspring.Model.Role;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Repository.UtilisateurRepository;
import com.example.cmuspring.Service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static com.example.cmuspring.Validator.UtilisateurValidator.utilisateurId;
import static com.example.cmuspring.Validator.UtilisateurValidator.utilisateurValidator;

@Service
@AllArgsConstructor
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService {


    UtilisateurRepository utilisateurRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UtilisateurDto loadUserById(String id) {
        Optional<Utilisateur> donnee = utilisateurRepository.findById(id);
        return UtilisateurDto.fromEntity(donnee.orElseThrow(()-> new EntityNotFoundException("Utilisateur pas trouver ",
                ErrorCodes.UTILISATEUR_PAS_TROUVER)));
    }

    @Override
    public UtilisateurDto save(String role,UtilisateurDto dto) {
        List<String> errors = utilisateurValidator(role,dto);
        if (!errors.isEmpty()){
            log.error(errors.toString());
            throw new InvalidEntityException("Verrifier vos information si elle sont correctes",ErrorCodes.UTILISATEUR_PAS_VALID,errors);
        }
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
