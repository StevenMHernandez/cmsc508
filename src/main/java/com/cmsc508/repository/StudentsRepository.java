package com.cmsc508.repository;

import com.cmsc508.model.Student;
import com.cmsc508.rowmapper.StudentRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentsRepository extends BaseRepository {
    public StudentsRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public Student find(Integer id) {
        return jdbcTemplate.queryForObject("select * from students where id = ?", new Object[]{id}, new StudentRowMapper());
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", new StudentRowMapper());
    }

    public Student createOrUpdate(Student student) {
        jdbcTemplate.update("insert into students (oauth_user_id, name, email) values (?,?,?) on DUPLICATE key update name=values(name), email=values(email);", student.getOauthUserId(), student.getName(), student.getEmail());

        return jdbcTemplate.queryForObject("select * from students where oauth_user_id = ?", new Object[]{student.getOauthUserId()}, new StudentRowMapper());
    }

    public void addCourse(Long studentId, Integer courseId) {
        jdbcTemplate.update("insert into course_student (studentId, courseId) VALUES (?,?)", new Object[]{studentId, courseId});
    }
}
