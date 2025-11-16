package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.MedicalCheckDTO;
import com.shelter.shelter.entities.MedicalCheck;
import org.mapstruct.Mapper;

@Mapper
public interface MedicalCheckMapper {
  MedicalCheckDTO medicalCheckToMedicalCheckDTO(MedicalCheck medicalCheck);

  MedicalCheck medicalCheckDTOToMedicalCheck(MedicalCheckDTO medicalCheckDTO);
}
