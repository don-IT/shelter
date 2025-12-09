package com.shelter.shelter.dtos;

import com.shelter.shelter.entities.Animal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdopterDTO {
  private Long id;
  private String name;
  private String contact;
  private String city;
  private List<Animal> animals;
}
