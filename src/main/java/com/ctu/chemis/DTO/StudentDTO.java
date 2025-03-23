package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * DTO for {@link com.ctu.chemis.model.Student}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDTO {
    long id;
    AccountDTO account;
    SchoolDTO school;
    GradeDTO grade;
    ClassDTO classes;
}