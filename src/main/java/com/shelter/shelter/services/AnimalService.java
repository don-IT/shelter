package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Status;
import java.util.List;

public interface AnimalService {
  Animal createAnimal(Animal animal);

  Animal updateAnimal(Long id, Animal updated);

  void deleteAnimal(Long id);

  Animal getAnimal(Long id);

  List<Animal> getAllAnimals();

  Animal addAdopter(Long animalId, Long adopterId);

  Animal updateStatus(Long animalId, Status status);
}
