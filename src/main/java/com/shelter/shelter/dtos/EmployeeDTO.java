package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.entities.Shelter;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
  private Long id;
  private String name;
  private String role;
  private Shelter shelter;
  private List<MedicalCheck> medicalChecks;
}
