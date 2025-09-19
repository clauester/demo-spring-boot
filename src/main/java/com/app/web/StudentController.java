package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.persistance.entity.StudentEntity;
import com.app.service.StudentService;
import com.app.web.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/estudiantes")
public class StudentController {
    
    private final StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/promedio")
    public ResponseEntity<List<StudentEntity>> getStudentSummary(@PathVariable Integer id){
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO student){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(StudentDTO student){
        return ResponseEntity.ok().build();
    }
}
