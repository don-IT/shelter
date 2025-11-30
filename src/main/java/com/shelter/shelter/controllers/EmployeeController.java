package com.shelter.shelter.controllers;

import com.shelter.shelter.dtos.EmployeeDTO;
import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.mappers.EmployeeMapper;
import com.shelter.shelter.services.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;
  private final EmployeeMapper employeeMapper;

  @PostMapping
  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
    log.info("Received request to create employee: {}", employeeDTO);

    var employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
    var saved = employeeService.createEmployee(employee);

    log.info("Employee created with ID: {}", saved.getId());
    return ResponseEntity.ok(employeeMapper.employeeToEmployeeDTO(saved));
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
    log.info("Fetching employee with ID: {}", id);

    var employee = employeeService.getEmployee(id);

    log.info("Employee found: ID {}", id);
    return ResponseEntity.ok(employeeMapper.employeeToEmployeeDTO(employee));
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> getEmployees() {
    log.info("Fetching all employees");

    var employeeDTOs =
        employeeService.getEmployees().stream().map(employeeMapper::employeeToEmployeeDTO).toList();

    log.info("Total employees found: {}", employeeDTOs.size());
    return ResponseEntity.ok(employeeDTOs);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(
      @PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {

    log.info("Updating employee ID {} with data: {}", id, employeeDTO);

    var updated =
        employeeService.updateEmployee(id, employeeMapper.employeeDTOToEmployee(employeeDTO));

    log.info("Employee ID {} updated successfully", id);
    return ResponseEntity.ok(employeeMapper.employeeToEmployeeDTO(updated));
  }

  @GetMapping("/{id}/medical-checks")
  public ResponseEntity<List<MedicalCheck>> getMedicalChecksByEmployee(@PathVariable Long id) {
    log.info("Fetching medical checks for employee ID {}", id);

    var checks = employeeService.getMedicalChecksByEmployee(id);

    log.info("Employee ID {} has {} medical checks", id, checks.size());
    return ResponseEntity.ok(checks);
  }
}
