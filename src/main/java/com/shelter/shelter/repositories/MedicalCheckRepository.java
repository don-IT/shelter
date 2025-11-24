package com.shelter.shelter.repositories;

import com.shelter.shelter.entities.MedicalCheck;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MedicalCheckRepository extends CrudRepository<MedicalCheck, Long> {
  List<MedicalCheck> findByAnimal_Id(Long animalId);

  List<MedicalCheck> findByEmployee_Id(Long employeeId);
}
