package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.ShelterDTO;
import com.shelter.shelter.entities.Shelter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShelterMapper {
  ShelterDTO shelterToShelterDTO(Shelter shelter);

  Shelter shelterDTOToShelter(ShelterDTO shelterDTO);
}
