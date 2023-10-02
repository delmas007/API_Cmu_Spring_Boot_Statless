package com.example.cmuspring.Repository;

import com.example.cmuspring.Model.DossierPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DossierConsultationRepository extends JpaRepository<DossierPatient,String> {


    DossierPatient findByNumeroCmu(String numeroCmu);
}
