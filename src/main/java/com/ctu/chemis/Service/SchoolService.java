package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.SchoolDTO;
import com.ctu.chemis.Repository.SchoolRepository;
import com.ctu.chemis.mapper.SchoolMapper;
import com.ctu.chemis.model.School;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public List<SchoolDTO> getAllSchool() {
        return schoolRepository.findAll()
                .stream().map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }

    public SchoolDTO getSchoolById(Long id) {
        return schoolMapper.toSchoolDTO(
                schoolRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("School not found"))
        );
    }

    public ResponseEntity<String> createSchool(SchoolDTO schoolDTO) {
        School school = schoolMapper.toSchool(schoolDTO);

        school.setId(0);
        School saveSchool = schoolRepository.save(school);

        if (saveSchool.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("School added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("School added failed");
        }
    }

    @Transactional
    public SchoolDTO updateSchool(SchoolDTO schoolDTO, Long schoolId) {

        School school = schoolRepository.findById(schoolId).orElseThrow(
                () -> new RuntimeException("School id not found: " + schoolId)
        );

        if (schoolDTO.getId() != school.getId()) {
            throw new RuntimeException("School id mismatch");
        }

        schoolMapper.updateSchoolFromDTO(school, schoolDTO);

        return schoolMapper.toSchoolDTO(school);
    }


}
