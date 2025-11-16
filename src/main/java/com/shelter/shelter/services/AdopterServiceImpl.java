package com.shelter.shelter.services;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.repositories.AdopterRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdopterServiceImpl implements AdopterService {
  private final AdopterRepository adopterRepository;

  public AdopterServiceImpl(AdopterRepository adopterRepository) {
    this.adopterRepository = adopterRepository;
  }

  /**
   * @param adopter
   * @return
   */
  @Override
  public Adopter createAdopter(Adopter adopter) {
    return adopterRepository.save(adopter);
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
