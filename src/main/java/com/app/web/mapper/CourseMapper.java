package com.app.web.mapper;

import org.mapstruct.Mapper;

import com.app.persistance.entity.CourseEntity;
import com.app.web.dto.CourseDTO;

@Mapper(componentModel = "spring")
public interface CourseMapper {
     CourseDTO toDto(CourseEntity course);
    CourseEntity toEntity(CourseDTO dto);
}
