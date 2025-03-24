package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.SchoolDTO;
import com.ctu.chemis.model.School;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface SchoolMapper {

    School toSchool(SchoolDTO schoolDTO);

    SchoolDTO toSchoolDTO(School school);

    void updateSchoolFromDTO(@MappingTarget School school, SchoolDTO schoolDTO);

}
