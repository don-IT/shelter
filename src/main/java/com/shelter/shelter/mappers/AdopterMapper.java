package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.AdopterDTO;
import com.shelter.shelter.entities.Adopter;
import org.mapstruct.Mapper;

@Mapper
public interface AdopterMapper {
  Adopter adopterToAdopter(Adopter adopter);

  AdopterDTO adopterToAdopterDTO(Adopter adopter);
}
