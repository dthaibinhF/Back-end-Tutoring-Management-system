package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.StudentDTO;
import com.ctu.chemis.Repository.StudentRepository;
import com.ctu.chemis.mapper.StudentMapper;
import com.ctu.chemis.model.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream().map(studentMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentBy(long studentId) {
        return studentMapper.toStudentDTO(
                studentRepository.findById(studentId).orElseThrow(
                        () -> new RuntimeException("Student not found"))
        );
    }

    @Transactional
    public StudentDTO updateStudent(StudentDTO studentDTO, long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student id not found: " + studentId)
        );

        if (student.getSchool().getId() != studentDTO.getSchool().getId()) {
            throw new RuntimeException("School id mismatch");
        }

        studentMapper.updateStudentFromDTO(student, studentDTO);

        return studentMapper.toStudentDTO(student);

    }


}
