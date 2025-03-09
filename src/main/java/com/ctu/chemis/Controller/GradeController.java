package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.GradeDTO;
import com.ctu.chemis.Service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/all")
    public ResponseEntity<List<GradeDTO>> getGrades() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/{gradeId}")
    public ResponseEntity<GradeDTO> getGrade(@PathVariable long gradeId) {
        return ResponseEntity.ok(gradeService.getGradeById(gradeId));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGrade(@RequestBody GradeDTO gradeDTO) {
        return gradeService.addGrade(gradeDTO);
    }

}

