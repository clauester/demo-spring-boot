package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.persistance.entity.StudentEntity;
import com.app.persistance.repository.StudentRepository;
import com.app.web.dto.StudentDTO;
import com.app.web.mapper.GradeMapper;
import com.app.web.mapper.StudentMapper;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDTO> getAll(){
        return this.studentMapper.toDtos(studentRepository.findAll()) ;
    }

  
   
    
}
