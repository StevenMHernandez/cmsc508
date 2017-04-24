package com.cmsc508.rowmapper;

import com.cmsc508.model.Course;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(rs.getLong("id"));
        course.setDepartmentId(rs.getString("departmentId"));
        course.setCourseNumber(rs.getInt("courseNumber"));
        course.setInstructorId(rs.getInt("instructorId"));
        return course;
    }
}