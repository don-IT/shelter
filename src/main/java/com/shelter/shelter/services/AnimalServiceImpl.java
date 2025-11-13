package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Status;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {
  /**
   * @param animal
   * @return
   */
  @Override
  public Animal createAnimal(Animal animal) {
    return null;
  }

  /**
   * @param id
   * @param updated
   * @return
   */
  @Override
  public Animal updateAnimal(Long id, Animal updated) {
    return null;
  }

  /**
   * @param id
   */
  @Override
  public void deleteAnimal(Long id) {}

  /**
   * @param id
   * @return
   */
  @Override
  public Animal getAnimal(Long id) {
    return null;
  }

  /**
   * @return
   */
  @Override
  public List<Animal> getAllAnimals() {
    return List.of();
  }

  /**
   * @param animalId
   * @param adopterId
   * @return
   */
  @Override
  public Animal addAdopter(Long animalId, Long adopterId) {
    return null;
  }

  /**
   * @param animalId
   * @param status
   * @return
   */
  @Override
  public Animal updateStatus(Long animalId, Status status) {
    return null;
  }
}
