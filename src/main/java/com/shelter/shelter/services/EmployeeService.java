package com.shelter.shelter.services;

import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;

public interface EmployeeService {
  Employee createEmployee(Employee employee);

  Employee updateEmployee(Long id, Employee updated);

  Employee getEmployee(Long id);

  List<Employee> getEmployees();

  List<MedicalCheck> getMedicalChecksByEmployee(Long employeeId);
}
