package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.GradeDTO;
import com.ctu.chemis.model.Grade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    Grade toGrade(GradeDTO gradeDTO);

    GradeDTO toGradeDTO(Grade grade);
}
