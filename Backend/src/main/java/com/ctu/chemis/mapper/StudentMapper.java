package com.ctu.chemis.mapper;


import com.ctu.chemis.DTO.StudentDTO;
import com.ctu.chemis.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "classes", source = "classes")
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
    void updateStudentFromDTO(@MappingTarget Student student, StudentDTO studentDTO);
}
