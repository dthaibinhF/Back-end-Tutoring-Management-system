package com.ctu.chemis.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * DTO for {@link com.ctu.chemis.model.School}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolDTO {
    long id;
    String schoolName;
//    List<StudentDTO> students;
}