package com.cmsc508.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @RequestMapping(value="/student/{student_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model) {
        // load student with projects from database
        return "students/show";
    }

    @RequestMapping(value="/student/{student_id}/comment", method=RequestMethod.POST)
    public String comment(@PathVariable Integer student_id, Model model) {
        // store comment for student
        // redirect to show
        return "redirect";
    }
}
