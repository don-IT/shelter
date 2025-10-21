package com.shelter.shelter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {
    @Id
    private Long id;

    private String animalName;

    private String animalSpecies;

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
