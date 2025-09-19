package com.app.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.persistance.entity.StudentEntity;

import com.app.web.dto.StudentDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDto(StudentEntity student);
    StudentEntity toEntity(StudentDTO dto);
    List<StudentDTO> toDtos(List<StudentEntity> students);

}
