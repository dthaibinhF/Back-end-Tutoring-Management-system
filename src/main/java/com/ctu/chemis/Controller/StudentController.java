package com.ctu.chemis.Controller;

import com.ctu.chemis.Repository.StudentRepository;
import com.ctu.chemis.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

}
