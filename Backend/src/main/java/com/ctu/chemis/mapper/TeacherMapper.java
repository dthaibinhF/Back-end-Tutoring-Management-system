package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.TeacherDTO;
import com.ctu.chemis.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeacherMapper {
    Teacher toTeacher(TeacherDTO teacherDTO);

    TeacherDTO toTeacherDTO(Teacher teacher);

    void updateFromDTO(@MappingTarget Teacher teacher, TeacherDTO teacherDTO);
}
