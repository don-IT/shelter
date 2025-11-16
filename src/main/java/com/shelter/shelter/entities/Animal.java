package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
}
