package com.shelter.shelter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
  @Id private Long id;

  private String animalName;

  private String animalSpecies;

  @ManyToOne
  @JoinColumn(name = "shelter_id")
  private Shelter shelter;

  public Shelter getShelter() {
    return shelter;
  }

  public void setShelter(Shelter shelter) {
    this.shelter = shelter;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getAnimalName() {
    return animalName;
  }

  public void setAnimalName(String animalName) {
    this.animalName = animalName;
  }

  public String getAnimalSpecies() {
    return animalSpecies;
  }

  public void setAnimalSpecies(String animalSpecies) {
    this.animalSpecies = animalSpecies;
  }
}
