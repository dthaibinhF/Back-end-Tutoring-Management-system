package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.ScoreDTO;
import com.ctu.chemis.Service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.prefix + "/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/all")
    public ResponseEntity<List<ScoreDTO>> getAll() {
        return ResponseEntity.ok(scoreService.getAllScores());
    }

    @GetMapping("/{scoreId}")
    public ResponseEntity<ScoreDTO> getScoreById(@PathVariable long scoreId) {
        return ResponseEntity.ok(scoreService.getScoreBy(scoreId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ScoreDTO>> getScoreByStudent(@PathVariable long studentId) {
        return ResponseEntity.ok(scoreService.getListScoreOfStudentBy(studentId));
    }

    @PutMapping("/{scoreId}")
    public ResponseEntity<ScoreDTO> updateScore(@RequestBody ScoreDTO scoreDTO, @PathVariable long scoreId) {
        return ResponseEntity.ok(scoreService.updateScore(scoreDTO, scoreId));
    }

    @PostMapping("/add")
    public ResponseEntity<ScoreDTO> createScore(@RequestBody ScoreDTO scoreDTO) {
        return ResponseEntity.ok(scoreService.createScore(scoreDTO));
    }

    @DeleteMapping("/{scoreId}")
    public ResponseEntity<String> deleteScore(@PathVariable long scoreId) {
        return ResponseEntity.ok(scoreService.deleteScore(scoreId));
    }


}
