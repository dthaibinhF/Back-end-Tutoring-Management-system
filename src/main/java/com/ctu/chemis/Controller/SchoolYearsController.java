package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.GradeRepository;
import com.ctu.chemis.Repository.SchoolYearsRepository;
import com.ctu.chemis.model.Grade;
import com.ctu.chemis.model.SchoolYear;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/school-years")
@RequiredArgsConstructor
public class SchoolYearsController {

    private final SchoolYearsRepository schoolYearsRepository;
    private final GradeRepository gradeRepository;

    @GetMapping("/all")
    public List<SchoolYear> getAllSchoolYears() {
        return schoolYearsRepository.findAll();
    }

    @GetMapping("/{schoolYearsId}")
    public SchoolYear getSingleSchoolYear(@PathVariable long schoolYearsId) {

        return schoolYearsRepository.findById(schoolYearsId).orElseThrow(
                () -> new RuntimeException("School year not found - " + schoolYearsId)
        );
    }

    @GetMapping("/current")
    public SchoolYear getCurrentSchoolYear() {

        LocalDate currentDate = new Date(System.currentTimeMillis()).toLocalDate();
        return schoolYearsRepository.findCurrentSchoolYear(currentDate).orElseThrow(
                () -> new RuntimeException("No school year found")
        );
    }

    //waiting for the front end to send the data
    @PostMapping(value = "/add", consumes = "application/json")
    public SchoolYear addSchoolYear(@RequestBody SchoolYear schoolYear) {

        schoolYear.setId(0);
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
            return saveSchoolYear;
        } else {
            throw new RuntimeException("school year added failed");
        }
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody String body) {
        return ResponseEntity.ok("Received: " + body);
    }


}
