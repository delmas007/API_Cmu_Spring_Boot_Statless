package com.example.cmuspring.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "consultation")
@EntityListeners(AuditingEntityListener.class)
public class Consultation implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "date_creation",nullable = false,updatable = false)
  @CreatedDate
  private Instant dateCreation;

  @Column(name = "examen_physique")
  private String examenPhysique;

  @Column(name = "discussion_des_symptomes")
  private String discussionDesSymptomes;

  private String diagnostic;

  private String ordonnance;

  @Column(name = "taux_reduction")
  private int tauxReduction;

  private String code;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "numero_CMU")
  private DossierPatient numeroCmu;


  @Column(name = "id_utilisateur")
  private String idUtilisateur;



}
