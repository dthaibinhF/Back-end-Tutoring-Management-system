package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.PeriodTimeDTO;
import com.ctu.chemis.Repository.PeriodTimeRepository;
import com.ctu.chemis.execption.MissMatchException;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.PeriodTimeMapper;
import com.ctu.chemis.model.PeriodTime;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeriodTimeService {
    private final PeriodTimeRepository periodTimeRepository;
    private final PeriodTimeMapper periodTimeMapper;

    public List<PeriodTimeDTO> getAllPeriodTimes() {
        return periodTimeRepository.findAll()
                .stream()
                .map(periodTimeMapper::toPeriodTimeDTO)
                .collect(Collectors.toList());
    }


    public PeriodTimeDTO getPeriodTimeBy(long periodTimeId) {
        return periodTimeMapper.toPeriodTimeDTO(
                periodTimeRepository.findById(periodTimeId).orElseThrow(
                        () -> new NotFoundException("Period Time id not found - " + periodTimeId))
        );
    }

    @Transactional
    public PeriodTimeDTO updatePeriodTime(PeriodTimeDTO periodTimeDTO, long periodTimeId) {
        PeriodTime periodTime = periodTimeRepository.findById(periodTimeId).orElseThrow(
                () -> new NotFoundException("Period Time id not found: " + periodTimeId)
        );
        if (periodTime.getId() != periodTimeDTO.getId()) {
            throw new MissMatchException("Period Time id mismatch");
        }
        periodTimeMapper.updateFormDTO(periodTime, periodTimeDTO);
        return periodTimeMapper.toPeriodTimeDTO(periodTime);
    }

    public PeriodTimeDTO createPeriodTime(PeriodTimeDTO periodTimeDTO) {
        PeriodTime periodTime = periodTimeMapper.toPeriodTime(periodTimeDTO);
        periodTime.setId(0);
        PeriodTime savedPeriodTime = periodTimeRepository.save(periodTime);
        return periodTimeMapper.toPeriodTimeDTO(savedPeriodTime);
    }

    @Transactional
    public ResponseEntity<String> deletePeriodTime(long periodTimeId) {
        periodTimeRepository.deleteById(periodTimeId);
        return ResponseEntity.ok("Period Time deleted successfully");
    }
}
