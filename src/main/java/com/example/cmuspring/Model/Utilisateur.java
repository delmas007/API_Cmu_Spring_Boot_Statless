package com.example.cmuspring.Model;


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


  @ManyToOne
  @JoinColumn(name = "role")
  private Role role;

  @Column(name = "numero_CMU")
  private String numeroCmu;

  @OneToOne(mappedBy = "idUtilisateur")
  private DossierPatient dossierPatient;

}
