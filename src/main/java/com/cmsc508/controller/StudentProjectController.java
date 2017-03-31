package com.cmsc508.controller;

import com.cmsc508.model.Project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class StudentProjectController {
    @RequestMapping(value="/student/{student_id}/projects", method=RequestMethod.GET)
    public String index(@PathVariable Integer student_id, Model model) {
        // get all projects for student
        model.addAttribute("id", student_id);
        return "students/projects/index";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model) {
        // get project data with comments and stars
        Project project = new Project(new Date(), project_id, student_id, "My Project Name abc", "Simple description goes here.", new Date());
        model.addAttribute("project", project);
        return "students/projects/show";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}/comment", method=RequestMethod.POST)
    public String comment(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model) {
        // store comment for student
        // redirect to show
        return "redirect";
    }
}
