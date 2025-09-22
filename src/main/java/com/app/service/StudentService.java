package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.app.persistance.entity.StudentEntity;
import com.app.persistance.repository.StudentRepository;
import com.app.web.dto.request.StudentRequestDTO;
import com.app.web.dto.response.GradeSummary;
import com.app.web.dto.response.StudentResponseDTO;
import com.app.web.mapper.StudentMapper;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    

    private StudentService(StudentRepository studentRepository,StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        
    }

    public List<StudentResponseDTO> getAll(){
        return studentRepository
                .findAll()
                .stream()
                .map(entity -> studentMapper.toDto(entity)).collect(Collectors.toList()) ;
    }

    public StudentResponseDTO getById(Integer id){
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
        return studentMapper.toDto(student);
    }

   public StudentResponseDTO add(StudentRequestDTO student){
        StudentEntity duplicate = studentRepository.findByEmail(student.getEmail());
        if(duplicate == null){
            StudentEntity studentEntity =studentRepository.save(studentMapper.toEntity(student));
        return studentMapper.toDto(studentEntity);
        }     
        throw new RuntimeException("El correo "+duplicate.getEmail()+" ya fue registrado");
        }

    public StudentResponseDTO update(StudentRequestDTO student){
        StudentEntity existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + student.getId()));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        StudentEntity saved = studentRepository.save(existingStudent);
        return studentMapper.toDto(saved);
    }

    public void delete(Integer id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Estudiante no existe o no esta disponible para eliminar");
        }
        studentRepository.deleteById(id);
    }

    public GradeSummary getSummary(Integer id){
        return studentRepository.gradeSummaryById(id);
    }

}
