package com.shelter.shelter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shelter {
    @Id
    private Long id;

    private String shelterName;


    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Shelter() {

    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Shelter(Animal animal) {
        this.animal = animal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }
}
