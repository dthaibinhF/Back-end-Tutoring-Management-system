package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.SalaryDTO;
import com.ctu.chemis.Service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Path.prefix + "/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @GetMapping("/all")
    public ResponseEntity<List<SalaryDTO>> getAllSalary() {
        return ResponseEntity.ok(salaryService.getAllSalary());
    }

    @GetMapping("/{salaryId}")
    public ResponseEntity<SalaryDTO> getSingleSalary(@PathVariable long salaryId) {
        return ResponseEntity.ok(salaryService.getSingleSalary(salaryId));
    }
}
