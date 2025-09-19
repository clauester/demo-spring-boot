package com.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.persistance.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    
}
