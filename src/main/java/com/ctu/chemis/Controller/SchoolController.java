package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.SchoolDTO;
import com.ctu.chemis.Service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/all")
    public ResponseEntity<List<SchoolDTO>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchool());
    }

    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolDTO> getSingleSchools(@PathVariable Long schoolId) {
        return ResponseEntity.ok(schoolService.getSchoolById(schoolId));
    }

    @PutMapping("/{schoolId}")
    public SchoolDTO updateSchool(@RequestBody SchoolDTO schoolDTO, @PathVariable Long schoolId) {
        return schoolService.updateSchool(schoolDTO, schoolId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSchool(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.createSchool(schoolDTO);
    }

}
