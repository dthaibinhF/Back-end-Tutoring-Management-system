package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.ClassDTO;
import com.ctu.chemis.model.Classes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClassMapper {

    Classes toClass(ClassDTO classDTO);

    @Mapping(target = "maxStudent", source = "maxStudent")
    ClassDTO toClassDTO(Classes classes);

    void updateClassFromDTO(@MappingTarget Classes classes, ClassDTO classDTO);
}
