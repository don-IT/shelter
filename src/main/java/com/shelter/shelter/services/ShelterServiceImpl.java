package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.Shelter;
import com.shelter.shelter.repositories.ShelterRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {
  private final ShelterRepository shelterRepository;

  @Override
  public Shelter createShelter(Shelter shelter) {
    return shelterRepository.save(shelter);
  }

  @Override
  public Shelter updateShelter(Long id, Shelter shelter) {
    return shelterRepository
        .findById(id)
        .map(
            s -> {
              s.setName(shelter.getName());
              s.setAddress(shelter.getAddress());
              s.setPhone(shelter.getPhone());
              s.setAnimals(shelter.getAnimals());
              s.setEmployees(shelter.getEmployees());
              return s;
            })
        .orElse(null);
  }

  @Override
  public Shelter getShelter(Long id) {
    return shelterRepository.findById(id).orElse(null);
  }

  @Override
  public List<Animal> getAnimalsInShelter(Long shelterId) {
    return shelterRepository.findById(shelterId).map(Shelter::getAnimals).orElse(null);
  }

  @Override
  public List<Employee> getEmployeesInShelter(Long shelterId) {
    return shelterRepository.findById(shelterId).map(Shelter::getEmployees).orElse(null);
  }
}
