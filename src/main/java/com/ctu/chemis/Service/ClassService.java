package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.ClassDTO;
import com.ctu.chemis.Repository.ClassRepository;
import com.ctu.chemis.execption.MissMatchException;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.ClassMapper;
import com.ctu.chemis.model.Classes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClassService {

    private final ClassRepository classRepository;
    private final ClassMapper classMapper;

    public List<ClassDTO> getAllClasses() {
        return classRepository.findAll()
                .stream().map(classMapper::toClassDTO)
                .collect(java.util.stream.Collectors.toList());
    }


    public ClassDTO getClassBy(long classId) {
        return classMapper.toClassDTO(
                classRepository.findById(classId).orElseThrow(
                        () -> new NotFoundException("Class not found"))
        );
    }


    public ClassDTO updateClass(ClassDTO classDTO, long classId) {

        Classes classes = classRepository.findById(classId).orElseThrow(
                () -> new NotFoundException("Class id not found: " + classId)
        );

        if (classDTO.getId() != classes.getId()) {
            throw new MissMatchException("Class id mismatch");
        }

        classMapper.updateClassFromDTO(classes, classDTO);

        return classMapper.toClassDTO(classRepository.save(classes));
    }

    public ResponseEntity<String> deleteClass(long classId) {
        try {
            classRepository.findById(classId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Class not found");
        }
        classRepository.deleteById(classId);
        return ResponseEntity.ok("Class deleted successfully");
    }
}
