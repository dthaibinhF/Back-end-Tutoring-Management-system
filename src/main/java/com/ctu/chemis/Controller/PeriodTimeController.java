package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.PeriodTimeDTO;
import com.ctu.chemis.Service.PeriodTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/period-time")
@RequiredArgsConstructor
public class PeriodTimeController {
    private final PeriodTimeService periodTimeService;

    @GetMapping("/all")
    public ResponseEntity<List<PeriodTimeDTO>> getAllPeriodTimes() {
        return ResponseEntity.ok(periodTimeService.getAllPeriodTimes());
    }

    @GetMapping("/{periodTimeId}")
    public ResponseEntity<PeriodTimeDTO> getPeriodTimeById(@PathVariable long periodTimeId) {
        return ResponseEntity.ok(periodTimeService.getPeriodTimeBy(periodTimeId));
    }

    @PutMapping("/{periodTimeId}")
    public ResponseEntity<PeriodTimeDTO> updatePeriodTime(@RequestBody PeriodTimeDTO periodTimeDTO, @PathVariable long periodTimeId) {
        return ResponseEntity.ok(periodTimeService.updatePeriodTime(periodTimeDTO, periodTimeId));
    }

    @PostMapping("/create")
    public ResponseEntity<PeriodTimeDTO> createPeriodTime(@RequestBody PeriodTimeDTO periodTimeDTO) {
        return ResponseEntity.ok(periodTimeService.createPeriodTime(periodTimeDTO));
    }

    @DeleteMapping("/{periodTimeId}")
    public ResponseEntity<String> deletePeriodTime(@PathVariable long periodTimeId) {
        return periodTimeService.deletePeriodTime(periodTimeId);
    }
}
