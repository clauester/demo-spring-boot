package com.app.web.dto;

import java.util.List;
import com.app.persistance.entity.GradeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Integer id;
    private String name;
    private String description;
    private List<GradeEntity> grades;
}
