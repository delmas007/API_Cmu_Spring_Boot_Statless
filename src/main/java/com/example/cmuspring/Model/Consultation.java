package com.example.cmuspring.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultation implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "date_creation")
  private Instant dateCreation;

  @Column(name = "examen_physique")
  private String examenPhysique;

  @Column(name = "discussion_des_symptomes")
  private String discussionDesSymptomes;

  private String diagnostic;

  private String ordonnance;

  @Column(name = "taux_reduction")
  private long tauxReduction;

  private String code;

  @Column(name = "numero_CMU")
  private String numeroCmu;

  @Column(name = "id_utilisateur")
  private String idUtilisateur;



}
