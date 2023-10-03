package com.example.cmuspring.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

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


//  @CreatedDate
  @Column(name = "date_creation")
  private Instant dateCreation;

//  @LastModifiedDate
  @Column(name = "date_modification")
  private Instant dateModification;

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

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "id_utilisateur")
  private Utilisateur idUtilisateur;

  @OneToMany(mappedBy = "numeroCmu")
  private List<Consultation> consultation;

  @PrePersist
  void  prePersist(){
    dateCreation = Instant.now();
  }
  @PreUpdate
  void preUpdate(){
    dateModification = Instant.now();
  }



}
