package com.cmsc508.repository;

import com.cmsc508.model.Project;
import com.cmsc508.rowmapper.ProjectRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProjectsRepository extends BaseRepository {
    public ProjectsRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Project> findAll() {
        return jdbcTemplate.query("select * from project", new ProjectRowMapper());
    }
}
