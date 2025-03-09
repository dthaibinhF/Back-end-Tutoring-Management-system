package com.ctu.chemis.DTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GradeDTO {
    long id;
    int grade;
    List<SchoolYearDTO> schoolYears;
}
