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
        return jdbcTemplate.queryForObject("select * from students where id = ?", new Object[] { id }, new StudentRowMapper());
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", new StudentRowMapper());
    }
}
