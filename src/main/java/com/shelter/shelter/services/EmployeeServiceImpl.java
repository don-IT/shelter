package com.shelter.shelter.services;

import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.repositories.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  @Override
  public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  @Transactional
  public Employee updateEmployee(Long id, Employee updated) {
    return employeeRepository
        .findById(id)
        .map(
            existing -> {
              existing.setName(updated.getName());
              existing.setRole(updated.getRole());
              existing.setShelter(updated.getShelter());
              existing.setMedicalChecks(updated.getMedicalChecks());
              return employeeRepository.save(existing);
            })
        .orElse(null);
  }

  @Override
  public Employee getEmployee(Long id) {
    return employeeRepository.findById(id).orElse(null);
  }

  @Override
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public List<MedicalCheck> getMedicalChecksByEmployee(Long employeeId) {
    return employeeRepository.findMedicalChecksByEmployeeId(employeeId);
  }
}
