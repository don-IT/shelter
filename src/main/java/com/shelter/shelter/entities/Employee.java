package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String role; // npr. Vet, Caretaker

  @ManyToOne
  @JoinColumn(name = "shelter_id")
  private Shelter shelter;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<MedicalCheck> medicalChecks;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Shelter getShelter() {
    return shelter;
  }

  public void setShelter(Shelter shelter) {
    this.shelter = shelter;
  }

  public List<MedicalCheck> getMedicalChecks() {
    return medicalChecks;
  }

  public void setMedicalChecks(List<MedicalCheck> medicalChecks) {
    this.medicalChecks = medicalChecks;
  }
}
