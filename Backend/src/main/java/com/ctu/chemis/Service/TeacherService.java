package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.TeacherDTO;
import com.ctu.chemis.Repository.TeacherRepository;
import com.ctu.chemis.execption.AlreadyExistException;
import com.ctu.chemis.execption.MissMatchException;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.TeacherMapper;
import com.ctu.chemis.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    public List<TeacherDTO> getAllTeacher() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toTeacherDTO)
                .collect(Collectors.toList());
    }

    public TeacherDTO getSingleTeacher(long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NotFoundException("Teacher id not found: " + teacherId));
        return teacherMapper.toTeacherDTO(teacher);
    }

    public ResponseEntity<TeacherDTO> createTeacher(TeacherDTO teacherDTO) {
        long id = teacherDTO.getId();
        if ((id != 0) && (teacherRepository.existsById(id))) {
            throw new AlreadyExistException("Teacher id " + id + " already existed.");
        }

        Teacher teacher = teacherMapper.toTeacher(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);

        return ResponseEntity.status(HttpStatus.CREATED).body(teacherMapper.toTeacherDTO(savedTeacher));
    }

    public ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO, long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new NotFoundException("Teacher id not found: " + teacherId)
        );

        if (teacherDTO.getId() != teacher.getId()) {
            throw new MissMatchException("Teacher id mismatch");
        } else {
            teacherMapper.updateFromDTO(teacher, teacherDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(teacherMapper.toTeacherDTO(teacherRepository.save(teacher)));
        }
    }

//
//    public ResponseEntity<String> deleteTeacher(long teacherId) {
//        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
//                () -> new NotFoundException("Teacher id not found: " + teacherId)
//        );
//
//        teacherRepository.deleteById(teacherId);
//        if (teacherRepository.existsById(teacherId)) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Teacher id " + teacherId + " not deleted.");
//        }
//        else {
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Teacher id " + teacherId + " deleted successfully.");
//        }
//    }
}
