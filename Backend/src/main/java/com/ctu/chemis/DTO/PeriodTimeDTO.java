package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

/**
 * DTO for {@link com.ctu.chemis.model.PeriodTime}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeriodTimeDTO {
    Integer id;
    String name;
    String dateOfWeek;
    LocalTime startAt;
    LocalTime endAt;
}