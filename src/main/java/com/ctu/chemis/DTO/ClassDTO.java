package com.ctu.chemis.DTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassDTO {

    long id;
    String name;
    String type;
    GradeDTO grade;
    List<PeriodTimeDTO> periodTimes;
}
