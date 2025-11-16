package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import java.util.List;
import lombok.Builder;

@Builder
public class ShelterDTO {
  private Long id;
  private String name;
  private String address;
  private String phone;
  private List<Animal> animals;
  private List<Employee> employees;
}
