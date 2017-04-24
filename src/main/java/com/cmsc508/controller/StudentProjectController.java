package com.cmsc508.controller;

import com.cmsc508.model.Project;
import com.cmsc508.repository.ProjectsRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentProjectController extends BaseController {
    @RequestMapping(value="/student/{student_id}/projects", method=RequestMethod.GET)
    public String index(@PathVariable Integer student_id, Model model) {
        List<Project> projects = new ProjectsRepository(this.jdbcTemplate).findAllForStudent(student_id);

        model.addAttribute("student", this.getStudent());
        model.addAttribute("projects", projects);

        return "students/projects/index";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model) {
        // get project data with comments and stars
        Project project = new Project();
        project.setName("My Project Name here");
        project.setDescription("A simple description.");

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
