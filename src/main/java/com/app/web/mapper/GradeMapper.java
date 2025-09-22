package com.app.web.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.app.persistance.entity.GradeEntity;
import com.app.web.dto.request.GradeRequestDTO;
import com.app.web.dto.response.GradeResponseDTO;

@Mapper(componentModel = "spring", 
uses = {StudentMapper.class, CourseMapper.class}
)
public interface GradeMapper {

    @Mappings({
        @Mapping(source = "student.id", target = "studentId"),
        @Mapping(source = "course.id", target = "courseId")
    })
    GradeResponseDTO toDto(GradeEntity note);

    @Mappings({
        @Mapping(source = "studentId", target = "student.id"),
        @Mapping(source = "courseId", target = "course.id")
    })
    GradeEntity toEntity(GradeRequestDTO dto);

    List<GradeRequestDTO> toDtos(List<GradeEntity> notes);
    List<GradeEntity> toEntities(List<GradeRequestDTO> dtos);
}
