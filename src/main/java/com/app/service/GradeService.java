package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.app.persistance.entity.GradeEntity;
import com.app.persistance.entity.StudentEntity;
import com.app.persistance.repository.NoteRepository;
import com.app.web.dto.request.GradeRequestDTO;
import com.app.web.dto.request.StudentRequestDTO;
import com.app.web.dto.response.GradeResponseDTO;
import com.app.web.dto.response.StudentResponseDTO;
import com.app.web.mapper.GradeMapper;
import com.app.web.mapper.StudentMapper;
@Service
public class GradeService {
    
    private final NoteRepository noteRepository;
    private final GradeMapper gradeMapper;

    private GradeService(NoteRepository noteRepository,GradeMapper gradeMapper){
        this.noteRepository = noteRepository;
        this.gradeMapper = gradeMapper;
    }

    public List<GradeResponseDTO> getAll(){
        return noteRepository.findAll()
        .stream()
        .map(entity -> gradeMapper.toDto(entity))
        .collect(Collectors.toList());
    }
    
    public GradeResponseDTO getById(Integer id){
        GradeEntity grade = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + id));
        return gradeMapper.toDto(grade);
    }

    public GradeResponseDTO add(GradeRequestDTO grade){
        GradeEntity gradeEntity = noteRepository.save(gradeMapper.toEntity(grade));
    return gradeMapper.toDto(gradeEntity);
   }  

   public GradeResponseDTO update(GradeRequestDTO grade){
        GradeEntity existingGrade = noteRepository.findById(grade.getId())
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con ID: " + grade.getId()));
        existingGrade.setCalification(grade.getCalification());

        GradeEntity saved = noteRepository.save(existingGrade);
        return gradeMapper.toDto(saved);
    }

    public void delete(Integer id){
        if(!noteRepository.existsById(id)){
            throw new RuntimeException("Nota no existe o no esta disponible para eliminar");
        }
        noteRepository.deleteById(id);
    }

}
