package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.PeriodTimeDTO;
import com.ctu.chemis.model.PeriodTime;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PeriodTimeMapper {
    PeriodTime toPeriodTime(PeriodTimeDTO periodTimeDTO);

    PeriodTimeDTO toPeriodTimeDTO(PeriodTime periodTime);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFormDTO(@MappingTarget PeriodTime periodTime, PeriodTimeDTO periodTimeDTO);
}