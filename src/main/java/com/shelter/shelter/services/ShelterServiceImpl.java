package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.Shelter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceImpl implements ShelterService {
  /**
   * @param shelter
   * @return
   */
  @Override
  public Shelter createShelter(Shelter shelter) {
    return null;
  }

  /**
   * @param id
   * @param shelter
   * @return
   */
  @Override
  public Shelter updateShelter(Long id, Shelter shelter) {
    return null;
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Shelter getShelter(Long id) {
    return null;
  }

  /**
   * @param shelterId
   * @return
   */
  @Override
  public List<Animal> getAnimalsInShelter(Long shelterId) {
    return List.of();
  }

  /**
   * @param shelterId
   * @return
   */
  @Override
  public List<Employee> getEmployeesInShelter(Long shelterId) {
    return List.of();
  }
}
