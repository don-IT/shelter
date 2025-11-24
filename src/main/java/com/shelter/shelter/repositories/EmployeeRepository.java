package com.shelter.shelter.repositories;

import com.shelter.shelter.entities.Employee;
import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query("SELECT e.medicalChecks as medicalChecks FROM Employee e WHERE e.id = :employeeId")
  List<MedicalCheck> findMedicalChecksByEmployeeId(Long employeeId);
}
