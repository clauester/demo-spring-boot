package com.app.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.StudentService;
import com.app.web.dto.request.StudentRequestDTO;
import com.app.web.dto.response.GradeSummary;
import com.app.web.dto.response.StudentResponseDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/estudiantes")
public class StudentController {
    
    private final StudentService studentService;


    public StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll(){
        return new ResponseEntity<>(studentService.getAll() , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody StudentRequestDTO student){
        return new ResponseEntity<>(studentService.add(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentResponseDTO> updateStudent(@RequestBody StudentRequestDTO student){
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}/promedio")
    public ResponseEntity<GradeSummary> getStudentSummary(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getSummary(id) , HttpStatus.OK);
    }


}
