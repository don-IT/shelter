package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "animals")
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String species;
  private Integer age;

  @Enumerated(EnumType.STRING)
  private Status status; // npr. AVAILABLE, ADOPTED, PENDING

  @ManyToOne
  @JoinColumn(name = "shelter_id")
  private Shelter shelter;

  @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
  private List<MedicalCheck> medicalChecks;

  @ManyToMany
  @JoinTable(
      name = "adoptions",
      joinColumns = @JoinColumn(name = "animal_id"),
      inverseJoinColumns = @JoinColumn(name = "adopter_id"))
  private List<Adopter> adopters;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
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

  public List<Adopter> getAdopters() {
    return adopters;
  }

  public void setAdopters(List<Adopter> adopters) {
    this.adopters = adopters;
  }
}
