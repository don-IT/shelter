package com.shelter.shelter.controllers;

import com.shelter.shelter.dtos.AnimalDTO;
import com.shelter.shelter.entities.Status;
import com.shelter.shelter.mappers.AnimalMapper;
import com.shelter.shelter.services.AnimalService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/animals")
public class AnimalController {
  private final AnimalService animalService;
  private final AnimalMapper animalMapper;

  @PostMapping
  public ResponseEntity<AnimalDTO> createAnimal(@RequestBody AnimalDTO animalDTO) {
    log.info("Received request to create animal: {}", animalDTO);

    var animal = animalMapper.animalDTOToAnimal(animalDTO);
    var saved = animalService.createAnimal(animal);

    log.info("Animal created with ID: {}", saved.getId());
    return ResponseEntity.ok(animalMapper.animalToAnimalDTO(saved));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AnimalDTO> getAnimal(@PathVariable Long id) {
    log.info("Fetching animal with ID: {}", id);

    var animal = animalService.getAnimal(id);
    log.info("Animal found: ID {}", id);

    return ResponseEntity.ok(animalMapper.animalToAnimalDTO(animal));
  }

  @GetMapping
  public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
    log.info("Fetching all animals");

    var animalDTOs =
        animalService.getAllAnimals().stream().map(animalMapper::animalToAnimalDTO).toList();

    log.info("Total animals found: {}", animalDTOs.size());
    return ResponseEntity.ok(animalDTOs);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AnimalDTO> updateAnimal(
      @PathVariable Long id, @RequestBody AnimalDTO animalDTO) {

    log.info("Updating animal ID {} with data: {}", id, animalDTO);

    var updated = animalService.updateAnimal(id, animalMapper.animalDTOToAnimal(animalDTO));

    log.info("Animal ID {} updated successfully", id);
    return ResponseEntity.ok(animalMapper.animalToAnimalDTO(updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
    log.info("Deleting animal with ID: {}", id);

    animalService.deleteAnimal(id);

    log.info("Animal ID {} deleted successfully", id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{animalId}/adopter/{adopterId}")
  public ResponseEntity<AnimalDTO> addAdopter(
      @PathVariable Long animalId, @PathVariable Long adopterId) {

    log.info("Assigning adopter ID {} to animal ID {}", adopterId, animalId);

    var updated = animalService.addAdopter(animalId, adopterId);

    log.info("Adopter ID {} assigned to animal ID {}", adopterId, animalId);
    return ResponseEntity.ok(animalMapper.animalToAnimalDTO(updated));
  }

  @PutMapping("/{animalId}/status")
  public ResponseEntity<AnimalDTO> updateStatus(
      @PathVariable Long animalId, @RequestParam Status status) {

    log.info("Updating status of animal ID {} to {}", animalId, status);

    var updated = animalService.updateStatus(animalId, status);

    log.info("Animal ID {} status updated to {}", animalId, status);
    return ResponseEntity.ok(animalMapper.animalToAnimalDTO(updated));
  }
}
