package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.SchoolYearDTO;
import com.ctu.chemis.Service.SchoolYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/school-years")
@RequiredArgsConstructor
public class SchoolYearsController {

    private final SchoolYearService schoolYearService;

    @GetMapping("/all")
    public ResponseEntity<List<SchoolYearDTO>> getAllSchoolYears() {
        return ResponseEntity.ok(schoolYearService.getAllSchoolYears());
    }

    @GetMapping("/{schoolYearsId}")
    public ResponseEntity<SchoolYearDTO> getSingleSchoolYear(@PathVariable long schoolYearsId) {
        return ResponseEntity.ok(schoolYearService.getSchoolYearBy(schoolYearsId));
    }

    @GetMapping("/current")
    public ResponseEntity<SchoolYearDTO> getCurrentSchoolYear() {
        return ResponseEntity.ok(schoolYearService.getCurrentSchoolYear());
    }

    //waiting for the front end to send the data
    @PostMapping(value = "/add")
    public ResponseEntity<SchoolYearDTO> addSchoolYear(@RequestBody SchoolYearDTO schoolYearDTO) {
        return ResponseEntity.ok(schoolYearService.createSchoolYear(schoolYearDTO));
    }

}
