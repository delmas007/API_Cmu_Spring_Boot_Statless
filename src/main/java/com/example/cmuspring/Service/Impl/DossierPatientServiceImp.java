package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.ConsultationDto;
import com.example.cmuspring.Dto.DossierPatientDto;
import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Exception.EntityNotFoundException;
import com.example.cmuspring.Exception.ErrorCodes;
import com.example.cmuspring.Exception.InvalidEntityException;
import com.example.cmuspring.Model.DossierPatient;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Repository.ConsultationRepository;
import com.example.cmuspring.Repository.DossierConsultationRepository;
import com.example.cmuspring.Service.DossierPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

import static com.example.cmuspring.Validator.DossierPatientValidator.*;

@Service
@Transactional
@Slf4j
public class DossierPatientServiceImp implements DossierPatientService {

    DossierConsultationRepository dossierConsultationRepository;
    UtilisateurServiceImp utilisateurServiceImp;
    ConsultationRepository consultationRepository;


    @Autowired
    public DossierPatientServiceImp(DossierConsultationRepository dossierConsultationRepository,
                                    UtilisateurServiceImp utilisateurServiceImp,
                                    ConsultationRepository consultationRepository) {
        this.dossierConsultationRepository = dossierConsultationRepository;
        this.utilisateurServiceImp=utilisateurServiceImp;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public DossierPatientDto ajouerDossierPatient(String id ,DossierPatientDto dto) {

        List<String> errors =dossierPatientValidatorAjouter(dto);
        UtilisateurDto ab = utilisateurServiceImp.loadUserById(id);
        if(!errors.isEmpty()){
            log.error(errors.toString());
            throw new InvalidEntityException("Verifier si vous avez correctement rempli",
                    ErrorCodes.DOSSIER_PATIENT_PAS_VALID,errors);
        }
        String numCmu = UUID.randomUUID().toString();
        DossierPatient donnee = DossierPatient.builder()
                .numeroCmu(numCmu)
                .ville(dto.getVille())
                .age(dto.getAge())
                .masculin(dto.getMasculin())
                .feminin(dto.getFeminin())
                .enceinte(dto.getEnceinte())
                .idUtilisateur(UtilisateurDto.toEntity(ab))
                .build();

        return DossierPatientDto.fromEntity(dossierConsultationRepository.save(donnee));
    }


    @Override
    public DossierPatientDto consulterDossierPatient(String numeroCmu) {
        return DossierPatientDto.fromEntity(dossierConsultationRepository.findByNumeroCmu(numeroCmu).orElseThrow(()->
                new EntityNotFoundException("Dossier patient inexistant avec le numero cmu ",ErrorCodes.DOSSIER_PATIENT_PAS_TROUVER)
        ));
    }

    @Override
    public DossierPatientDto modifierDossierPatient(DossierPatientDto dto) {
        DossierPatient donnee =DossierPatientDto.toEntity(consulterDossierPatient(dto.getNumeroCmu()));
        donnee.setAntecedentMedicaux(dto.getAntecedentMedicaux());
        donnee.setHistoriqueDeVaccination(dto.getHistoriqueDeVaccination());
        donnee.setResumesMedicaux(dto.getResumesMedicaux());
        return DossierPatientDto.fromEntity(dossierConsultationRepository.save(donnee));
    }


    @Override
    public void supprimerDossierPatient(String numeroCmu) {
        DossierPatientDto a = consulterDossierPatient(numeroCmu);
        consultationRepository.deleteByNumeroCmu(DossierPatientDto.toEntity(a));
        dossierConsultationRepository.deleteById(numeroCmu);
    }
}
