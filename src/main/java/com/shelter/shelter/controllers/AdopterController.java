package com.shelter.shelter.controllers;

import com.shelter.shelter.dtos.AdopterDTO;
import com.shelter.shelter.dtos.AnimalDTO;
import com.shelter.shelter.entities.Animal;
import com.shelter.shelter.mappers.AdopterMapper;
import com.shelter.shelter.mappers.AnimalMapper;
import com.shelter.shelter.services.AdopterService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/adopters")
public class AdopterController {
  private final AdopterService adopterService;
  private final AdopterMapper adopterMapper;
  private final AnimalMapper animalMapper;

  @PostMapping
  public ResponseEntity<AdopterDTO> createAdopter(@RequestBody AdopterDTO adopterDTO) {
    log.info("Received request to create adopter: {}", adopterDTO);

    var adopter = adopterMapper.adopterDTOToAdopter(adopterDTO);
    var saved = adopterService.createAdopter(adopter);

    log.info("Adopter created with ID: {}", saved.getId());
    return ResponseEntity.ok(adopterMapper.adopterToAdopterDTO(saved));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdopterDTO> getAdopter(@PathVariable Long id) {
    log.info("Received request to fetch adopter with ID: {}", id);

    return adopterService
        .getAdopter(id)
        .map(
            adopter -> {
              log.info("Adopter found: {}", adopter.getId());
              return ResponseEntity.ok(adopterMapper.adopterToAdopterDTO(adopter));
            })
        .orElseGet(
            () -> {
              log.warn("Adopter with ID {} not found", id);
              return ResponseEntity.notFound().build();
            });
  }

  @GetMapping
  public ResponseEntity<List<AdopterDTO>> getAllAdopters() {
    log.info("Received request to fetch all adopters");

    List<AdopterDTO> adopterDTOs =
        adopterService.getAllAdopters().stream().map(adopterMapper::adopterToAdopterDTO).toList();

    log.info("Total adopters found: {}", adopterDTOs.size());
    return ResponseEntity.ok(adopterDTOs);
  }

  @GetMapping("/{id}/animals")
  public ResponseEntity<List<AnimalDTO>> getAdoptedAnimals(@PathVariable Long id) {
    log.info("Received request to fetch adopted animals for adopter ID: {}", id);

    List<Animal> animals = adopterService.getAdoptedAnimals(id);

    log.info("Adopter ID {} has {} adopted animals", id, animals.size());

    List<AnimalDTO> animalDTOs = animals.stream().map(animalMapper::animalToAnimalDTO).toList();

    return ResponseEntity.ok(animalDTOs);
  }
}
