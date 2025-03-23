package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.ctu.chemis.model.Salary}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDTO {
    long id;
    LocalDate datePayAt;
    BigDecimal salary;
    TeacherDTO teacher;
}