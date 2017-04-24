package com.cmsc508.rowmapper;

import com.cmsc508.model.Project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("id"));
        project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));
        project.setStudentId(rs.getLong("studentId"));
        project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));
        project.setCreatedAt(rs.getDate("created_at"));
        project.setUpdatedAt(rs.getDate("updated_at"));
        return project;
    }
}