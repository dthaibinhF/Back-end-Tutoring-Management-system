package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.SchoolYearDTO;
import com.ctu.chemis.model.SchoolYear;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GradeMapper.class})
public interface SchoolYearMapper {
    SchoolYear toSchoolYear(SchoolYearDTO schoolYearDTO);

    SchoolYearDTO toSchoolYearDTO(SchoolYear schoolYear);
}
