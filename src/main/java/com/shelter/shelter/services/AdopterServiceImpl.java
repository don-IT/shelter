package com.shelter.shelter.services;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.Animal;
import java.util.List;

public class AdopterServiceImpl implements AdopterService {
  /**
   * @param adopter
   * @return
   */
  @Override
  public Adopter createAdopter(Adopter adopter) {
    return null;
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Adopter getAdopter(Long id) {
    return null;
  }

  /**
   * @return
   */
  @Override
  public List<Adopter> getAllAdopters() {
    return List.of();
  }

  /**
   * @param adopterId
   * @return
   */
  @Override
  public List<Animal> getAdoptedAnimals(Long adopterId) {
    return List.of();
  }
}
