package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.SalaryDTO;
import com.ctu.chemis.model.Salary;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SalaryMapper {
    Salary toSalary(SalaryDTO salaryDTO);

    SalaryDTO toSalaryDTO(Salary salary);

    void updateFromDTO(@MappingTarget Salary salary, SalaryDTO salaryDTO);
}
