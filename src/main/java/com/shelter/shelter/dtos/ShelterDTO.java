package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShelterDTO {
  private Long id;
  private String name;
  private String address;
  private String phone;
  private List<Animal> animals;
  private List<Employee> employees;
}
