package com.app.web;

import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.app.service.CourseService;
import com.app.web.dto.request.CourseRequestDTO;
import com.app.web.dto.response.CourseResponseDTO;
import com.app.web.dto.response.GradeSummary;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    private final CourseService courseService;

    private CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAll(){
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getById(@PathVariable Integer id){
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> addCourse(@RequestBody CourseRequestDTO course){
        return new ResponseEntity<>(courseService.add(course), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseResponseDTO> updateCourse(@RequestBody CourseRequestDTO course){
        return new ResponseEntity<>(courseService.update(course), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id){
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/promedio")
    public ResponseEntity<GradeSummary> getCourseSummary(@PathVariable Integer id){
        return new ResponseEntity<>(courseService.getSummary(id), HttpStatus.OK);
    }
    
}
