package com.shelter.shelter.services;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.Animal;
import java.util.List;
import java.util.Optional;

public interface AdopterService {
  Adopter createAdopter(Adopter adopter);

  Optional<Adopter> getAdopter(Long id);

  List<Adopter> getAllAdopters();

  List<Animal> getAdoptedAnimals(Long adopterId);
}
