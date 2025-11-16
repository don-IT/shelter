package com.shelter.shelter.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "shelters")
public class Shelter {
  @Id private Long id;

  private String name;
  private String address;
  private String phone;

  @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
  private List<Animal> animals;

  @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
  private List<Employee> employees;
}
