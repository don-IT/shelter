package com.shelter.shelter.services;

import com.shelter.shelter.entities.MedicalCheck;
import com.shelter.shelter.repositories.MedicalCheckRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalCheckServiceImpl implements MedicalCheckService {
  private final MedicalCheckRepository medicalCheckRepository;

  @Override
  public MedicalCheck createCheck(MedicalCheck check) {
    return medicalCheckRepository.save(check);
  }

  @Override
  public List<MedicalCheck> getChecksForAnimal(Long animalId) {
    return medicalCheckRepository.findByAnimal_Id(animalId);
  }

  @Override
  public List<MedicalCheck> getChecksByEmployee(Long employeeId) {
    return medicalCheckRepository.findByEmployee_Id(employeeId);
  }
}
