package com.app.web.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.app.persistance.entity.CourseEntity;
import com.app.web.dto.request.CourseRequestDTO;
import com.app.web.dto.response.CourseResponseDTO;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponseDTO toDto(CourseEntity course);
    List<CourseResponseDTO> toDtos(List<CourseEntity> courses);
    CourseEntity toEntity(CourseRequestDTO dto);
}
