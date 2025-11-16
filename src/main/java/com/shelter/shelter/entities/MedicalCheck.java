package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "medical_checks")
public class MedicalCheck {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate date;
  private String description;

  @ManyToOne
  @JoinColumn(name = "animal_id")
  private Animal animal;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;
}
