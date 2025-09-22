package com.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.persistance.entity.CourseEntity;
import com.app.web.dto.response.GradeSummary;

public interface CourseRespository extends JpaRepository<CourseEntity, Integer>{
    @Query(value = """
                select 
                c.name ,
                AVG(g.calification ) as summary  
                from public.grade g 
                join student s 
                    ON s.student_id = g.student_id
                join course c 
                    on c.course_id = g.course_id 
                where g.course_id  = :courseId
                group by c.name
                        """, nativeQuery = true)
     GradeSummary courseSummaryById(@Param("courseId") Integer id);
}
