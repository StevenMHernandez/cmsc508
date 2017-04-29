package com.cmsc508.repository;

import com.cmsc508.model.Activity;
import com.cmsc508.rowmapper.ActivityFeedRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ActivitiesRepository extends BaseRepository {
    public ActivitiesRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public List<Activity> newest(long studentId) {
        return jdbcTemplate.query("CALL user_activity_feed(?)", new ActivityFeedRowMapper(), studentId);
    }
}
