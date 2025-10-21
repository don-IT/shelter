package com.shelter.shelter.repositories;

import com.shelter.shelter.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
