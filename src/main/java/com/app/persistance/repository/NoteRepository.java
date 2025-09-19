package com.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.persistance.entity.GradeEntity;

public interface NoteRepository extends JpaRepository<GradeEntity, Integer> {
    
}
