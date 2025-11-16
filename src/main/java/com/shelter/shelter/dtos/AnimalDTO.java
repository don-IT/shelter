package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.entities.Shelter;
import com.shelter.shelter.entities.Status;
import java.util.List;
import lombok.Builder;

@Builder
public class AnimalDTO {
  private Long id;
  private String name;
  private String species;
  private Integer age;
  private Status status; // npr. AVAILABLE, ADOPTED, PENDING
  private Shelter shelter;
  private List<MedicalCheck> medicalChecks;
  private List<Adopter> adopters;
}
