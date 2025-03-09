package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.SchoolYearDTO;
import com.ctu.chemis.Repository.GradeRepository;
import com.ctu.chemis.Repository.SchoolYearsRepository;
import com.ctu.chemis.mapper.SchoolYearMapper;
import com.ctu.chemis.model.Grade;
import com.ctu.chemis.model.SchoolYear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolYearService {

    private final SchoolYearsRepository schoolYearsRepository;
    private final GradeRepository gradeRepository;
    private final SchoolYearMapper schoolYearMapper;


    public List<SchoolYearDTO> getAllSchoolYears() {
        return schoolYearsRepository.findAll()
                .stream().map(schoolYearMapper::toSchoolYearDTO)
                .collect(Collectors.toList());
    }

    public SchoolYearDTO getSchoolYearBy(long schoolYearId) {
        return schoolYearMapper.toSchoolYearDTO(
                schoolYearsRepository.findById(schoolYearId).orElseThrow(
                        () -> new RuntimeException("School Year not found"))
        );
    }

    public SchoolYearDTO getCurrentSchoolYear() {
        LocalDate currentDate = new Date(System.currentTimeMillis()).toLocalDate();
        return schoolYearMapper.toSchoolYearDTO(
                schoolYearsRepository.findCurrentSchoolYear(currentDate).orElseThrow(
                        () -> new RuntimeException("No school year found")
                )
        );
    }

    public SchoolYearDTO createSchoolYear(SchoolYearDTO schoolYearDTO) {
        //transfer DTO to Entity
        SchoolYear schoolYear = schoolYearMapper.toSchoolYear(schoolYearDTO);
        //set id to 0 to avoid conflict
        schoolYear.setId(0);
        //get all grades from repository
        List<Grade> grades = gradeRepository.findAll();
        schoolYear.setGrades(grades);
        grades.forEach(grade -> {
            List<SchoolYear> schoolYears = new ArrayList<>();
            if (grade.getSchoolYears() != null) {
                schoolYears = grade.getSchoolYears();
            }
            schoolYears.add(schoolYear);
            grade.setSchoolYears(schoolYears);
        });
        SchoolYear saveSchoolYear = schoolYearsRepository.save(schoolYear);

        if (saveSchoolYear.getId() > 0) {
            return schoolYearMapper.toSchoolYearDTO(saveSchoolYear);
        } else {
            throw new RuntimeException("school year added failed");
        }
    }


}

