package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.persistance.entity.CourseEntity;
import com.app.persistance.repository.CourseRespository;

@Service
public class CourseService {
    
    private final CourseRespository courseRespository;

    private CourseService(CourseRespository courseRespository){
        this.courseRespository = courseRespository;
    }

    public List<CourseEntity> getAll(){
        return courseRespository.findAll();
    }
}
