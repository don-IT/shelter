package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "adopters")
public class Adopter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String contact;
  private String city;

  @ManyToMany(mappedBy = "adopters")
  private List<Animal> animals;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
