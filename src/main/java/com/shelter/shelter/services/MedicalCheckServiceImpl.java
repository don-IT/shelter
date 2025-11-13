package com.shelter.shelter.services;

import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;

public class MedicalCheckServiceImpl implements MedicalCheckService {
  /**
   * @param check
   * @return
   */
  @Override
  public MedicalCheck createCheck(MedicalCheck check) {
    return null;
  }

  /**
   * @param animalId
   * @return
   */
  @Override
  public List<MedicalCheck> getChecksForAnimal(Long animalId) {
    return List.of();
  }

  /**
   * @param employeeId
   * @return
   */
  @Override
  public List<MedicalCheck> getChecksByEmployee(Long employeeId) {
    return List.of();
  }
}
