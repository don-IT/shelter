package com.shelter.shelter.repositories;

import com.shelter.shelter.entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
