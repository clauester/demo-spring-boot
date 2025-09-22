package com.app.web;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.GradeService;
import com.app.web.dto.request.GradeRequestDTO;
import com.app.web.dto.response.GradeResponseDTO;

@RestController
@RequestMapping("/api/notas")
public class GradeController {
    
    private final GradeService gradeService;

    private GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<GradeResponseDTO>> getAll(){
        return new ResponseEntity<>(gradeService.getAll() , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradeResponseDTO> getById(@PathVariable Integer id){
        return new ResponseEntity<>(gradeService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<GradeResponseDTO> addGrade(@RequestBody GradeRequestDTO grade){
        return new ResponseEntity<>(gradeService.add(grade), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<GradeResponseDTO> updateGrade(@RequestBody GradeRequestDTO grade){
        return new ResponseEntity<>(gradeService.add(grade), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Integer id){
        gradeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
