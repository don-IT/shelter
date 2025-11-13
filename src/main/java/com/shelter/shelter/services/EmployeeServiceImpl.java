package com.shelter.shelter.services;

import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
  /**
   * @param employee
   * @return
   */
  @Override
  public Employee createEmployee(Employee employee) {
    return null;
  }

  /**
   * @param id
   * @param updated
   * @return
   */
  @Override
  public Employee updateEmployee(Long id, Employee updated) {
    return null;
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Employee getEmployee(Long id) {
    return null;
  }

  /**
   * @return
   */
  @Override
  public List<Employee> getEmployees() {
    return List.of();
  }

  /**
   * @param employeeId
   * @return
   */
  @Override
  public List<MedicalCheck> getMedicalChecksByEmployee(Long employeeId) {
    return List.of();
  }
}
