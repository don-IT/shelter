package com.shelter.shelter.controllers;

import com.shelter.shelter.dtos.MedicalCheckDTO;
import com.shelter.shelter.mappers.MedicalCheckMapper;
import com.shelter.shelter.services.MedicalCheckService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/medical-checks")
public class MedicalCheckController {

  private final MedicalCheckService medicalCheckService;
  private final MedicalCheckMapper medicalCheckMapper;

  @PostMapping
  public ResponseEntity<MedicalCheckDTO> createMedicalCheck(@RequestBody MedicalCheckDTO checkDTO) {
    log.info("Received request to create medical check: {}", checkDTO);

    var entity = medicalCheckMapper.medicalCheckDTOToMedicalCheck(checkDTO);
    var saved = medicalCheckService.createCheck(entity);

    log.info("Medical check created with ID: {}", saved.getId());
    return ResponseEntity.ok(medicalCheckMapper.medicalCheckToMedicalCheckDTO(saved));
  }

  @GetMapping("/animal/{animalId}")
  public ResponseEntity<List<MedicalCheckDTO>> getChecksForAnimal(@PathVariable Long animalId) {
    log.info("Fetching medical checks for animal ID: {}", animalId);

    var checks =
        medicalCheckService.getChecksForAnimal(animalId).stream()
            .map(medicalCheckMapper::medicalCheckToMedicalCheckDTO)
            .toList();

    log.info("Found {} medical checks for animal ID {}", checks.size(), animalId);
    return ResponseEntity.ok(checks);
  }

  @GetMapping("/employee/{employeeId}")
  public ResponseEntity<List<MedicalCheckDTO>> getChecksByEmployee(@PathVariable Long employeeId) {
    log.info("Fetching medical checks for employee ID: {}", employeeId);

    var checks =
        medicalCheckService.getChecksByEmployee(employeeId).stream()
            .map(medicalCheckMapper::medicalCheckToMedicalCheckDTO)
            .toList();

    log.info("Found {} medical checks for employee ID {}", checks.size(), employeeId);
    return ResponseEntity.ok(checks);
  }
}
