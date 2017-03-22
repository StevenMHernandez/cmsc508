package com.cmsc508.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseAddController {
    @RequestMapping(value="/courses/add", method=RequestMethod.GET)
    public String index(@PathVariable Integer student_id, Model model) {
        // send list of courses the authenticated user is enrolled in to the view
        // send list of available courses to view
        return "courses/add/index";
    }

    @RequestMapping(value="/courses/add", method=RequestMethod.POST)
    public String add(Model model) {
        // relate courses to the user
        // store in database
        // redirect to index
        return "redirect";
    }
}
