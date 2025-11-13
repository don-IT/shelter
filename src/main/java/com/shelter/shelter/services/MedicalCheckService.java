package com.shelter.shelter.services;

import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;

public interface MedicalCheckService {
  MedicalCheck createCheck(MedicalCheck check);

  List<MedicalCheck> getChecksForAnimal(Long animalId);

  List<MedicalCheck> getChecksByEmployee(Long employeeId);
}
