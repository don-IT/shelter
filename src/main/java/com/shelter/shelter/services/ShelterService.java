package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.Shelter;
import java.util.List;

public interface ShelterService {
  Shelter createShelter(Shelter shelter);

  Shelter updateShelter(Long id, Shelter shelter);

  Shelter getShelter(Long id);

  List<Animal> getAnimalsInShelter(Long shelterId);

  List<Employee> getEmployeesInShelter(Long shelterId);
}
