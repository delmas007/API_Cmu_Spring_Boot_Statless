package com.example.cmuspring.Model;


import jakarta.persistence.Column;
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
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

  @Id
  private String id;

  private String password;

  private String nom;

  private String prenom;

  private String role;

  @Column(name = "numero_CMU")
  private String numeroCmu;

}
