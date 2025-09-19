package com.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.persistance.entity.CourseEntity;

public interface CourseRespository extends JpaRepository<CourseEntity, Integer>{
    
}
