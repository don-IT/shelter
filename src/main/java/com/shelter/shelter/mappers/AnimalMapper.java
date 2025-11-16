package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.AnimalDTO;
import com.shelter.shelter.entities.Animal;
import org.mapstruct.Mapper;

@Mapper
public interface AnimalMapper {
  Animal animalDTOToAnimal(AnimalDTO animalDTO);

  AnimalDTO animalToAnimalDTO(Animal animal);
}
