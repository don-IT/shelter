package com.shelter.shelter.repositories;

import com.shelter.shelter.entities.Adopter;
import com.shelter.shelter.entities.Animal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdopterRepository extends JpaRepository<Adopter, Long> {
  @Query("SELECT a FROM Animal a JOIN a.adopters ad WHERE ad.id = :adopterId")
  List<Animal> findAnimalsByAdopter(@Param("adopterId") Long adopterId);
}
