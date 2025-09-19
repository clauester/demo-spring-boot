package com.app.web.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.app.persistance.entity.GradeEntity;
import com.app.web.dto.GradeDTO;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, CourseMapper.class})
public interface GradeMapper {
     @Mappings({
        @Mapping(source = "student.id", target = "studentId"),
        @Mapping(source = "course.id", target = "courseId")
    })
    GradeDTO toDto(GradeEntity note);

    @Mappings({
        @Mapping(source = "studentId", target = "student.id"),
        @Mapping(source = "courseId", target = "course.id")
    })
    GradeEntity toEntity(GradeDTO dto);

    List<GradeDTO> toDtos(List<GradeEntity> notes);
    List<GradeEntity> toEntities(List<GradeDTO> dtos);
}
