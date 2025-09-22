package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.app.persistance.entity.CourseEntity;
import com.app.persistance.repository.CourseRespository;
import com.app.web.dto.request.CourseRequestDTO;
import com.app.web.dto.response.CourseResponseDTO;
import com.app.web.dto.response.GradeSummary;
import com.app.web.mapper.CourseMapper;

@Service
public class CourseService {
    
    private final CourseRespository courseRespository;
    private final CourseMapper courseMapper;
    

    public CourseService(CourseRespository courseRespository,CourseMapper courseMapper){
        this.courseRespository = courseRespository;
        this.courseMapper = courseMapper;
    }

    public List<CourseResponseDTO> getAll(){
        return courseRespository.findAll()
        .stream()
        .map(entity -> courseMapper.toDto(entity))
        .collect(Collectors.toList());
    }

    public CourseResponseDTO getById(Integer id){
        CourseEntity course = courseRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        return courseMapper.toDto(course);
    }

    public CourseResponseDTO add(CourseRequestDTO course){
        CourseEntity courseEntity = courseRespository.save(courseMapper.toEntity(course));
        return courseMapper.toDto(courseEntity);
    } 

    public CourseResponseDTO update(CourseRequestDTO course){
        CourseEntity existingCourse = courseRespository.findById(course.getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + course.getId()));
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());

        CourseEntity saved = courseRespository.save(existingCourse);
        return courseMapper.toDto(saved);
    }

    public void delete(Integer id){
        if(!courseRespository.existsById(id)){
            throw new RuntimeException("Curso no existe o no esta disponible para eliminar");
        }
        courseRespository.deleteById(id);
    }

    public GradeSummary getSummary(Integer id){
        return courseRespository.courseSummaryById(id);
    }
}
