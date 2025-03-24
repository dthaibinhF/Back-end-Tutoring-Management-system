package com.ctu.chemis.Controller;

import com.ctu.chemis.Constant.Path;
import com.ctu.chemis.DTO.ClassDTO;
import com.ctu.chemis.Service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.prefix + "/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping("/create")
    public ResponseEntity<ClassDTO> createClass(@RequestBody ClassDTO classDTO) {
        ClassDTO savedClass = classService.createClass(classDTO);

        if (savedClass != null) {
            return ResponseEntity.ok(savedClass);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassDTO>> getClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{classId}")
    public ResponseEntity<ClassDTO> getSingleClass(@PathVariable long classId) {
        return ResponseEntity.ok(classService.getClassBy(classId));
    }

    @PutMapping("/{classId}")
    public ResponseEntity<ClassDTO> updateClass(@RequestBody ClassDTO classDTO, @PathVariable long classId) {
        return ResponseEntity.ok(classService.updateClass(classDTO, classId));
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<String> deleteClass(@PathVariable long classId) {
        return classService.deleteClass(classId);
    }

}
