package com.shelter.shelter.services;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.repositories.AdopterRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService {
  private final AdopterRepository adopterRepository;

  @Override
  public Adopter createAdopter(Adopter adopter) {
    return adopterRepository.save(adopter);
  }

  @Override
  public Optional<Adopter> getAdopter(Long id) {
    return adopterRepository.findById(id);
  }

  @Override
  public List<Adopter> getAllAdopters() {
    return adopterRepository.findAll();
  }

  @Override
  public List<Animal> getAdoptedAnimals(Long adopterId) {
    return adopterRepository.findAnimalsByAdopter(adopterId);
  }
}
