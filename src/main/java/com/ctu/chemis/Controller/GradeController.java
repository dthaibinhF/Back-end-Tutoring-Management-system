package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.GradeRepository;
import com.ctu.chemis.model.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeRepository gradeRepository;

    @GetMapping("/all")
    public List<Grade> getGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping("/{gradeId}")
    public Grade getGrade(@PathVariable long gradeId) {

        return gradeRepository.findById(gradeId).orElseThrow(
                () -> new RuntimeException("Grade not found - " + gradeId)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGrade(@RequestBody Grade grade) {


        try {
            grade.setId(0);
            List<Grade> grades = gradeRepository.findAll();
            for (Grade g : grades) {
                if (g.getGrade() == (grade.getGrade())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Grade already exists");
                }
            }

            Grade savedGrade = gradeRepository.save(grade);

            if (savedGrade.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Grade added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Grade added failed");
            }


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred: " + e.getMessage());
        }

    }

}

