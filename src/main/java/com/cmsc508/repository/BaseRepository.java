package com.cmsc508.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseRepository {
    JdbcTemplate jdbcTemplate;

    public BaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
