package com.cmsc508.repository;

import com.cmsc508.model.Course;
import com.cmsc508.rowmapper.CourseRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CoursesRepository extends BaseRepository {
    public CoursesRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public Course find(Integer id) {
        return jdbcTemplate.queryForObject("select * from courses where id = ?", new Object[]{id}, new CourseRowMapper());
    }

    public List<Course> findAll() {
        return jdbcTemplate.query("select * from courses", new CourseRowMapper());
    }

    public List<Course> findStudentCourses(Long studentId) {
        return jdbcTemplate.query("select c.* from courses c, course_student cs where cs.studentId = ? and cs.studentId = cs.studentId and c.id = cs.courseId", new Object[]{studentId}, new CourseRowMapper());
    }

    public List<Course> findNonStudentCourses(Long studentId) {
        return jdbcTemplate.query("select c.* from courses c, course_student cs where c.id = cs.courseId and c.id NOT IN (select courseId from course_student where studentId = ?)", new Object[]{studentId}, new CourseRowMapper());
    }
}
