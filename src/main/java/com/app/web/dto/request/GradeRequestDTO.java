package com.app.web.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeRequestDTO {
    private Integer id;
    private BigDecimal calification;
    private Integer courseId;
    private Integer studentId;
}
