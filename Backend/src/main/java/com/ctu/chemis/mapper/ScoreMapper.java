package com.ctu.chemis.mapper;

import com.ctu.chemis.DTO.ScoreDTO;
import com.ctu.chemis.model.Score;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScoreMapper {
    Score toScore(ScoreDTO scoreDTO);

    ScoreDTO toScoreDTO(Score score);

    void updateScoreFromDTO(@MappingTarget Score score, ScoreDTO scoreDTO);
}