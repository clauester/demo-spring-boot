package com.app.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.persistance.entity.StudentEntity;
import com.app.web.dto.response.GradeSummary;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    StudentEntity findByEmail(String email);

    @Query(value = """
                select s.name, AVG(g.calification) as summary  from public.grade g 
                join student s 
                    ON s.student_id = g.student_id
                join course c 
                    on c.course_id = g.course_id 
                where g.student_id = :studentId
                group by s.name
                """, nativeQuery = true)
     GradeSummary gradeSummaryById(@Param("studentId") Integer id);

}
