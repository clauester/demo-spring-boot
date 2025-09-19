package com.app.web.dto;

import java.math.BigDecimal;

import com.app.persistance.entity.CourseEntity;
import com.app.persistance.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private Integer id;
    private BigDecimal calification;
    private CourseEntity course;
    private StudentEntity student;
}
