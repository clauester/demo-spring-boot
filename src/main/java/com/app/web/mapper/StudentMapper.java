package com.app.web.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.app.persistance.entity.StudentEntity;
import com.app.web.dto.request.StudentRequestDTO;
import com.app.web.dto.response.StudentResponseDTO;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO toDto(StudentEntity student);
    StudentEntity toEntity(StudentRequestDTO dto);
    List<StudentResponseDTO> toDtos(List<StudentEntity> students);

}
