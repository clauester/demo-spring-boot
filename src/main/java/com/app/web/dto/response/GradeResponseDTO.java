package com.app.web.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeResponseDTO {
    private BigDecimal calification;
    private String courseId;
    private String studentId;
    
}
