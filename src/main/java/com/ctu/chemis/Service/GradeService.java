package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.GradeDTO;
import com.ctu.chemis.Repository.GradeRepository;
import com.ctu.chemis.Repository.SchoolYearsRepository;
import com.ctu.chemis.mapper.GradeMapper;
import com.ctu.chemis.model.Grade;
import com.ctu.chemis.model.SchoolYear;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final SchoolYearsRepository schoolYearsRepository;
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;

    public List<GradeDTO> getAllGrades() {
        return gradeRepository.findAll()
                .stream().map(gradeMapper::toGradeDTO)
                .collect(Collectors.toList());
    }

    public GradeDTO getGradeById(long gradeId) {
        return gradeMapper.toGradeDTO(
                gradeRepository.findById(gradeId).orElseThrow(
                        () -> new RuntimeException("Grade not found"))
        );
    }

    public ResponseEntity<String> addGrade(GradeDTO gradeDTO) {

        Grade grade = gradeMapper.toGrade(gradeDTO);

        try {
            grade.setId(0);
            List<Grade> grades = gradeRepository.findAll();
            for (Grade g : grades) {
                if (g.getGrade() == (grade.getGrade())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Grade already exists");
                }
            }

            List<SchoolYear> schoolYears = schoolYearsRepository.findAll();
            grade.setSchoolYears(schoolYears);

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
