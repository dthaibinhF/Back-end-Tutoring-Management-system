package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link com.ctu.chemis.model.SchoolYear}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolYearDTO {
    long id;
    LocalDate startAt;
    LocalDate endAt;
    Integer yearStartAt;
    Integer yearEndAt;
    List<GradeDTO> grades;
}