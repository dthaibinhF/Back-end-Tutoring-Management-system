package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.ScoreDTO;
import com.ctu.chemis.Repository.ScoreRepository;
import com.ctu.chemis.Repository.StudentRepository;
import com.ctu.chemis.mapper.ScoreMapper;
import com.ctu.chemis.model.Score;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreMapper scoreMapper;
    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;

    public List<ScoreDTO> getAllScores() {
        return scoreRepository.findAll()
                .stream().map(scoreMapper::toScoreDTO)
                .collect(Collectors.toList());
    }

    public ScoreDTO getScoreBy(long scoreId) {
        Score score = scoreRepository.findById(scoreId).orElseThrow(
                () -> new RuntimeException("Score not found"));
        return scoreMapper.toScoreDTO(
                score
        );
    }


    public List<ScoreDTO> getListScoreOfStudentBy(long studentId) {
        return scoreRepository.getScoresByStudentId(studentId)
                .stream().map(scoreMapper::toScoreDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ScoreDTO updateScore(ScoreDTO scoreDTO, long scoreId) {

        Score score = scoreRepository.findById(scoreId).orElseThrow(
                () -> new RuntimeException("Score id not found: " + scoreId)
        );

        if (score.getId() != scoreDTO.getId()) {
            throw new RuntimeException("score id mismatch");
        }

        scoreMapper.updateScoreFromDTO(score, scoreDTO);
        scoreRepository.save(score);
        return scoreMapper.toScoreDTO(score);

    }

    public ScoreDTO createScore(ScoreDTO scoreDTO) {
        Score tempScore = scoreMapper.toScore(scoreDTO);
        tempScore.setId(0);
        Score savedScore = scoreRepository.save(tempScore);
        if (savedScore.getId() > 0) {
            return scoreMapper.toScoreDTO(savedScore);
        } else {
            throw new RuntimeException("Score not saved");
        }
    }

    @Transactional
    public String deleteScore(long scoreId) {
        Score score = scoreRepository.findById(scoreId).orElseThrow(
                () -> new RuntimeException("Score not found")
        );
        if (score != null) {
            scoreRepository.deleteById(scoreId);
            return "Score with id: " + scoreId + " deleted successfully";
        } else {
            throw new RuntimeException("Score not found");
        }
    }
}
