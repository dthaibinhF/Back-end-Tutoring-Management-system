package com.ctu.chemis.Controller;

import com.ctu.chemis.DTO.StudentDTO;
import com.ctu.chemis.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long studentId) {
        return ResponseEntity.ok(studentService.getStudentBy(studentId));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable long studentId) {
        return ResponseEntity.ok(studentService.updateStudent(studentDTO, studentId));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }
}
