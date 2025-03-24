package com.ctu.chemis.Repository;

import com.ctu.chemis.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> getScoresByStudentId(long studentId);
}