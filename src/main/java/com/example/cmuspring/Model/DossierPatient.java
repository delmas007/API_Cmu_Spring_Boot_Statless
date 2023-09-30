package com.example.cmuspring.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dossier_patient")
@EntityListeners(AuditingEntityListener.class)
public class DossierPatient implements Serializable {

  @Id
  @Column(name = "numero_CMU")
  private String numeroCmu;

  @CreatedDate
  @Column(name = "date_creation")
  private Instant dateCreation;

  private String ville;

  @Column(name = "antecedent_medicaux")
  private String antecedentMedicaux;

  @Column(name = "historique_de_vaccination")
  private String historiqueDeVaccination;

  @Column(name = "resumes_medicaux")
  private String resumesMedicaux;

  private int age;

  private Boolean masculin;

  private Boolean feminin;

  private Boolean enceinte;

  @Column(name = "id_utilisateur")
  private String idUtilisateur;



}
