package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.SchoolRepository;
import com.ctu.chemis.model.School;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolRepository schoolRepository;

    @GetMapping("/all")
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/{schoolId}")
    public School getSingleSchools(@PathVariable Long schoolId) {

        return schoolRepository.findById(schoolId).orElseThrow(
                () -> new RuntimeException("School not found - " + schoolId)
        );
    }

    @PutMapping("/{schoolId}")
    public School updateSchool(@RequestBody School school, @PathVariable Long schoolId) {

        School savedSchool = schoolRepository.findById(schoolId).orElseThrow(
                () -> new RuntimeException("School not found - " + schoolId)
        );

        if (school.getId() != savedSchool.getId()) {
            throw new RuntimeException("School id mismatch - " + schoolId);
        } else {
            return schoolRepository.save(school);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSchool(@RequestBody School school) {
        school.setId(0);
        School saveSchool = schoolRepository.save(school);
        if (saveSchool.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("School added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("School added failed");
        }
    }

}
