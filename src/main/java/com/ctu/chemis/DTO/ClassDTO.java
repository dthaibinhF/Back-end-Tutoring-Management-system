package com.ctu.chemis.DTO;


import com.ctu.chemis.model.PeriodTime;
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
    List<PeriodTime> periodTimes;

}
