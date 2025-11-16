package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public class MedicalCheckDTO {
  private Long id;
  private LocalDate date;
  private String description;
  private Animal animal;
  private Employee employee;
}
