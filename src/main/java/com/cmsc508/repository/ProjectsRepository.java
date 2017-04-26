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
        return jdbcTemplate.query("select * from projects", new ProjectRowMapper());
    }

    public List<Project> findAllForStudent(Integer student_id) {
        return jdbcTemplate.query("select * from projects where studentId = ?", new ProjectRowMapper(), student_id);
    }

    public void insert(Project project) {
        jdbcTemplate.update("insert into projects (name, description, studentId) VALUES (?,?,?)", new Object[]{project.getName(), project.getDescription(), project.getStudentId()});
    }

    public void update(Project project) {
        jdbcTemplate.update("update projects SET name=?, description=? WHERE id = ? AND studentId = ?", new Object[]{project.getName(), project.getDescription(), project.getId(), project.getStudentId()});
    }

    public Project get(Integer project_id, long student_id) {
        List<Project> projects = jdbcTemplate.query("select * from projects where id = ? and studentId = ?", new ProjectRowMapper(), project_id, student_id);

        if (projects.isEmpty()) {
            return null;
        }

        return projects.get(0);
    }
}
