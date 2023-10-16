package com.example.cmuspring.Repository;

import com.example.cmuspring.Model.Consultation;
import com.example.cmuspring.Model.DossierPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

//    Optional<Consultation> findByNumeroCmu(String numeroCmu);


//    @Query("SELECT Consultation FROM Consultation  WHERE numeroCmu = :numeroCmu")
    Optional<Consultation> findByNumeroCmu(DossierPatient numeroCmu);

//    Optional<Consultation> findByNumeroCmu(String numeroCmu);
    @Query("SELECT c FROM Consultation c WHERE c.numeroCmu.numeroCmu = :numeroCmu")
    Optional<Consultation> findByNumeroCmu(@Param("numeroCmu") String numeroCmu);


    //    @Query("DELETE Consultation where numeroCmu = :num")
    void deleteByNumeroCmu(DossierPatient numeroCmu);


}
