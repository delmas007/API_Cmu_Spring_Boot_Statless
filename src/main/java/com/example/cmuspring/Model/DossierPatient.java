package com.example.cmuspring.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dossier_patient")
public class DossierPatient implements Serializable {

  @Id
  private String numeroCmu;
  private String ville;
  private String antecedentMedicaux;
  private String historiqueDeVaccination;
  private String resumesMedicaux;
  private int age;
  private Boolean masculin;
  private Boolean feminin;
  private Boolean enceinte;
  private String idUtilisateur;



}
