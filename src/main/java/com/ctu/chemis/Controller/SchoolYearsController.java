package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.SchoolYearsRepository;
import com.ctu.chemis.model.Grade;
import com.ctu.chemis.model.SchoolYear;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/school-years")
@RequiredArgsConstructor
public class SchoolYearsController {

    private final SchoolYearsRepository schoolYearsRepository;

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

        Date currentDate = new Date(System.currentTimeMillis());
        return schoolYearsRepository.findCurrentSchoolYear(currentDate).orElseThrow(
                () -> new RuntimeException("No school year found")
        );
    }

    //waiting for the front end to send the data
    @PostMapping("/add")
    public ResponseEntity<String> addSchoolYear(@RequestBody SchoolYear schoolYear) {

        schoolYear.setId(0);
        List<Grade> grades = schoolYear.getGrades();
        grades.forEach(grade -> grade.setSchoolYear(schoolYear));
        SchoolYear saveSchoolYear = schoolYearsRepository.save(schoolYear);

        if (saveSchoolYear.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("School year added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("School year added failed");
        }
    }


}
