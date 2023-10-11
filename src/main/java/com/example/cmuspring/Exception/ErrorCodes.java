package com.example.cmuspring.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ErrorCodes {

    CONSULTATION_PAS_VALIDE(1000),
    CONSULTATION_PAS_TROUVER(1001),
    CONSULTATION_EXISTE_DEJA(1002),

    DOSSIER_PATIENT_PAS_VALID(2000),
    DOSSIER_PATIENT_PAS_TROUVER(2001),
    DOSSIER_PATIENT_EXISTE_DEJA(2002),
    UTILISATEUR_PAS_VALID(3000),
    UTILISATEUR_PAS_TROUVER(3001),
    UTILISATEUR_EXISTE_DEJA(3002),
    UTILISATEUR_PAS_ACCES(3002);

    @Getter
    @Setter
    private int code;
}
