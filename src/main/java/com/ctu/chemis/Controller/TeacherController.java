package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.TeacherDTO;
import com.ctu.chemis.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.prefix + "/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.createTeacher(teacherDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherDTO>> getAllTeacher() {
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> getSingleTeacher(@PathVariable long teacherId) {
        return ResponseEntity.ok(teacherService.getSingleTeacher(teacherId));
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherDTO> updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable long teacherId) {
        return teacherService.updateTeacher(teacherDTO, teacherId);
    }

//      if want to delete teacher -> delete account -> delete teacher
//    @DeleteMapping("/{teacherId}")
//    public ResponseEntity<String> deleteTeacher(@PathVariable long teacherId) {
//        return teacherService.deleteTeacher(teacherId);
//    }
}
