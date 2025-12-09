package com.shelter.shelter.mappers;

import com.shelter.shelter.dtos.EmployeeDTO;
import com.shelter.shelter.entities.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
  Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

  EmployeeDTO employeeToEmployeeDTO(Employee employee);
}
