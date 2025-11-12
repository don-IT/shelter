package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelters")
public class Shelter {
  @Id private Long id;

  private String shelterName;
  private String name;
  private String address;
  private String phone;

  @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
  private List<Animal> animals;

  @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
  private List<Employee> employees;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<Animal> getAnimals() {
    return animals;
  }

  public void setAnimals(List<Animal> animals) {
    this.animals = animals;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
