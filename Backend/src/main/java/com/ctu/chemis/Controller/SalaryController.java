package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.SalaryDTO;
import com.ctu.chemis.Service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.prefix + "/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @PostMapping("/create")
    public ResponseEntity<SalaryDTO> createSalary(@RequestBody SalaryDTO salaryDTO) {
        return salaryService.createSalary(salaryDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalaryDTO>> getAllSalary() {
        return ResponseEntity.ok(salaryService.getAllSalary());
    }

    @GetMapping("/{salaryId}")
    public ResponseEntity<SalaryDTO> getSingleSalary(@PathVariable long salaryId) {
        return salaryService.getSingleSalary(salaryId);
    }

    @PutMapping("/{salaryId}")
    public ResponseEntity<SalaryDTO> updateSalary(@RequestBody SalaryDTO salaryDTO, @PathVariable long salaryId) {
        return salaryService.updateSalary(salaryDTO, salaryId);
    }

    @DeleteMapping("/{salaryId}")
    public ResponseEntity<String> deleteSalary(@PathVariable long salaryId) {
        return salaryService.deleteSalary(salaryId);
    }
}
