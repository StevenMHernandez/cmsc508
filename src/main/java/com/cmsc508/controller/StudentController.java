package com.cmsc508.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/students/{student_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer student_id, Model model) {
        return "redirect:/student/" + student_id + "/projects";
    }

    @RequestMapping(value="/students/{student_id}/comment", method=RequestMethod.POST)
    public String comment(@PathVariable Integer student_id, Model model) {
        // store comment for student
        // redirect to show
        return "redirect";
    }
}
