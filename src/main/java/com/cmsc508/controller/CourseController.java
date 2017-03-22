package com.cmsc508.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {
    @RequestMapping(value="/courses/{course_id}", method=RequestMethod.POST)
    public String show(@PathVariable Integer course_id, Model model) {
        // load course from database
        // get all students in the course
        // get all projects from students in the course
        return "courses/show";
    }
}
