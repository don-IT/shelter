package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  // Getters and Setters
}
