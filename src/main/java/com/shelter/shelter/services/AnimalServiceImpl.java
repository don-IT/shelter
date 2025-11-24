package com.shelter.shelter.services;

import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.entities.Status;
import com.shelter.shelter.repositories.AnimalRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
  private final AnimalRepository animalRepository;
  private final AdopterService adopterService;

  @Override
  public Animal createAnimal(Animal animal) {
    return animalRepository.save(animal);
  }

  @Override
  public Animal updateAnimal(Long id, Animal updated) {
    var optionalAnimal = animalRepository.findById(id);
    if (optionalAnimal.isEmpty()) {
      return null;
    }
    var animal = optionalAnimal.get();
    animal.setName(updated.getName());
    animal.setAge(updated.getAge());
    animal.setStatus(updated.getStatus());
    animal.setSpecies(updated.getSpecies());
    animal.setAdopters(updated.getAdopters());
    animal.setMedicalChecks(updated.getMedicalChecks());

    return animal;
  }

  @Override
  public void deleteAnimal(Long id) {
    animalRepository.deleteById(id);
  }

  @Override
  public Animal getAnimal(Long id) {
    return animalRepository.findById(id).orElse(null);
  }

  @Override
  public List<Animal> getAllAnimals() {
    return animalRepository.findAll();
  }

  @Override
  @Transactional
  public Animal addAdopter(Long animalId, Long adopterId) {
    animalRepository
        .findById(animalId)
        .ifPresent(
            a -> adopterService.getAdopter(adopterId).ifPresent(ad -> a.getAdopters().add(ad)));
    return animalRepository.findById(animalId).orElse(null);
  }

  @Override
  public Animal updateStatus(Long animalId, Status status) {
    animalRepository.findById(animalId).ifPresent(a -> a.setStatus(status));
    return animalRepository.findById(animalId).orElse(null);
  }
}
