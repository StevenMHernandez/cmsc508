package com.cmsc508.rowmapper;

import com.cmsc508.model.Student;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setEmail(rs.getString("email"));
        student.setName(rs.getString("name"));
        student.setOauthUserId(rs.getString("oauth_user_id"));
        student.setShortDescription(rs.getString("short_description"));
        student.setGithubUrl(rs.getString("github_url"));
        student.setLinkedinUrl(rs.getString("linkedin_url"));
        student.setWebsiteUrl(rs.getString("website_url"));
        student.setCreatedAt(rs.getDate("created_at"));
        student.setUpdatedAt(rs.getDate("updated_at"));
        return student;
    }
}