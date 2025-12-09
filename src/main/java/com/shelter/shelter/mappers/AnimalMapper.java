package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.AnimalDTO;
import com.shelter.shelter.entities.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimalMapper {
  @Mapping(target = "id", source = "id") // optional if names match
  @Mapping(target = "name", source = "name")
  @Mapping(target = "species", source = "species")
  @Mapping(target = "age", source = "age")
  @Mapping(target = "status", source = "status")
  Animal animalDTOToAnimal(AnimalDTO animalDTO);

  AnimalDTO animalToAnimalDTO(Animal animal);
}
