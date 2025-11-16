package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.entities.Shelter;
import java.util.List;
import lombok.Builder;

@Builder
public class EmployeeDTO {
  private Long id;
  private String name;
  private String role;
  private Shelter shelter;
  private List<MedicalCheck> medicalChecks;
}
