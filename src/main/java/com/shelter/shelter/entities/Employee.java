package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String role;

  @ManyToOne
  @JoinColumn(name = "shelter_id")
  private Shelter shelter;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<MedicalCheck> medicalChecks;
}
