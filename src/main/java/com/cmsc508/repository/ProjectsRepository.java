package com.cmsc508.repository;

import com.cmsc508.model.Project;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProjectsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<Project> findAll() {
        return jdbcTemplate.query("select * from users", new ProjectRowMapper());
    }
}

class ProjectRowMapper implements RowMapper<Project>
{
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project user = new Project();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
