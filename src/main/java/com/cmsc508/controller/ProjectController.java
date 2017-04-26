package com.cmsc508.controller;

import com.cmsc508.model.Project;
import com.cmsc508.repository.ProjectsRepository;

import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableWebSecurity
public class ProjectController extends BaseController {
    @RequestMapping(value="/projects", method=RequestMethod.GET)
    public String index(Model model) {
        return "redirect:/student/" + this.getStudent().getId() + "/projects";
    }

    @RequestMapping(value="/projects/create", method=RequestMethod.GET)
    public String create(Model model) {
        return "students/projects/create";
    }

    @RequestMapping(value="/projects", method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String store(Model model, String name, String description) {
        Project project = new Project();
        project.setStudentId(this.getStudent().getId());
        project.setName(name);
        project.setDescription(description);

        new ProjectsRepository(this.jdbcTemplate).insert(project);
        return "redirect:/student/" + this.getStudent().getId() + "/projects";
    }

    @RequestMapping(value="/projects/{project_id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable Integer project_id, Model model) {
        // make sure user can update this project
        Project project = new ProjectsRepository(this.jdbcTemplate).get(project_id, this.getStudent().getId());

        if (project == null) {
            // throw exception
            return "redirect:/student/" + this.getStudent().getId() + "/projects";
        }

        model.addAttribute("project", project);

        return "students/projects/edit";
    }

    @RequestMapping(value="/projects/{project_id}", method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String update(@PathVariable Integer project_id, Model model, String name, String description) {
        Project project = new Project();
        project.setId(project_id);
        project.setStudentId(this.getStudent().getId());
        project.setName(name);
        project.setDescription(description);

        new ProjectsRepository(this.jdbcTemplate).update(project);
        return "redirect:/student/" + this.getStudent().getId() + "/projects";
    }
}
