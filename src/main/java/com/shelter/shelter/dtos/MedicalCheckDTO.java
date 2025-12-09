package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCheckDTO {
  private Long id;
  private LocalDate date;
  private String description;
  private Animal animal;
  private Employee employee;
}
