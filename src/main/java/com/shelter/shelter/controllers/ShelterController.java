package com.shelter.shelter.controllers;

import com.shelter.shelter.dtos.AnimalDTO;
import com.shelter.shelter.dtos.EmployeeDTO;
import com.shelter.shelter.dtos.ShelterDTO;
import com.shelter.shelter.mappers.AnimalMapper;
import com.shelter.shelter.mappers.EmployeeMapper;
import com.shelter.shelter.mappers.ShelterMapper;
import com.shelter.shelter.services.ShelterService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/shelters")
public class ShelterController {

  private final ShelterService shelterService;
  private final ShelterMapper shelterMapper;
  private final AnimalMapper animalMapper;
  private final EmployeeMapper employeeMapper;

  @PostMapping
  public ResponseEntity<ShelterDTO> createShelter(@RequestBody ShelterDTO shelterDTO) {
    log.info("Creating shelter: {}", shelterDTO);

    var entity = shelterMapper.shelterDTOToShelter(shelterDTO);
    var saved = shelterService.createShelter(entity);

    return ResponseEntity.ok(shelterMapper.shelterToShelterDTO(saved));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ShelterDTO> updateShelter(
      @PathVariable Long id, @RequestBody ShelterDTO shelterDTO) {

    log.info("Updating shelter ID: {} with data: {}", id, shelterDTO);

    var updated = shelterService.updateShelter(id, shelterMapper.shelterDTOToShelter(shelterDTO));

    return ResponseEntity.ok(shelterMapper.shelterToShelterDTO(updated));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ShelterDTO> getShelter(@PathVariable Long id) {
    log.info("Fetching shelter with ID: {}", id);

    var shelter = shelterService.getShelter(id);

    return ResponseEntity.ok(shelterMapper.shelterToShelterDTO(shelter));
  }

  @GetMapping("/{id}/animals")
  public ResponseEntity<List<AnimalDTO>> getAnimalsInShelter(@PathVariable Long id) {
    log.info("Fetching animals in shelter ID: {}", id);

    var animals =
        shelterService.getAnimalsInShelter(id).stream()
            .map(animalMapper::animalToAnimalDTO)
            .toList();

    return ResponseEntity.ok(animals);
  }

  @GetMapping("/{id}/employees")
  public ResponseEntity<List<EmployeeDTO>> getEmployeesInShelter(@PathVariable Long id) {
    log.info("Fetching employees in shelter ID: {}", id);

    var employees =
        shelterService.getEmployeesInShelter(id).stream()
            .map(employeeMapper::employeeToEmployeeDTO)
            .toList();

    return ResponseEntity.ok(employees);
  }
}
