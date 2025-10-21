package com.shelter.shelter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shelter {
    @Id
    private Long id;

    private String shelterName;

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
