package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
