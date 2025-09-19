package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.persistance.entity.GradeEntity;
import com.app.persistance.repository.NoteRepository;
@Service
public class GradeService {
    
    private final NoteRepository noteRepository;

    private GradeService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<GradeEntity> getAll(){
        return noteRepository.findAll();
    }

}
