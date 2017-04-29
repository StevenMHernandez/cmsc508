package com.cmsc508.rowmapper;

import com.cmsc508.model.Activity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityFeedRowMapper implements RowMapper<Activity> {
    @Override
    public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setType(rs.getString("type"));
        activity.setStudentId(rs.getInt("studentId"));
        activity.setStudentName(rs.getString("name"));
        activity.setTargetId(rs.getInt("targetId"));
        activity.setCreatedAt(rs.getDate("created_at"));
        return activity;
    }
}