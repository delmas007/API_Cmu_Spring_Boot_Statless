package com.example.cmuspring.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

  @Id
  private String id;

  private String password;

  private String nom;

  private String prenom;


  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "role")
  private Role role;

  @Column(name = "numero_CMU")
  private String numeroCmu;

  @JsonIgnore
  @OneToOne(mappedBy = "idUtilisateur")
  private DossierPatient dossierPatient;

}
