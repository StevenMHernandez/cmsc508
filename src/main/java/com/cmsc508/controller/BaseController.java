package com.cmsc508.controller;

import com.cmsc508.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    protected Student getStudent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (Student)auth.getPrincipal();
    }
}
