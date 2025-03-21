package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.StudentDTO;
import com.ctu.chemis.Repository.StudentRepository;
import com.ctu.chemis.mapper.StudentMapper;
import com.ctu.chemis.model.Student;
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

    //
    public StudentDTO createStudent(StudentDTO studentDTO) {

        //convert studentDTO to student
        Student student = studentMapper.toStudent(studentDTO);
        //set id to 0 to avoid id conflict
        student.setId(0);
        //save student to database
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toStudentDTO(savedStudent);
    }

    public StudentDTO updateStudent(StudentDTO studentDTO, long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student id not found: " + studentId)
        );

        if (student.getId() != studentDTO.getId()) {
            throw new RuntimeException("School id mismatch");
        }

        studentMapper.updateStudentFromDTO(student, studentDTO);

        return studentMapper.toStudentDTO(student);

    }


}
