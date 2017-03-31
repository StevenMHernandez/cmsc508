package com.cmsc508.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableWebSecurity
public class ProjectController {
    @RequestMapping(value="/projects/create", method=RequestMethod.GET)
    public String create(Model model) {
        return "students/projects/create";
    }

    @RequestMapping(value="/projects", method=RequestMethod.POST)
    public String store(Model model) {
        // store values
        return "redirect";
    }

    @RequestMapping(value="/projects/{project_id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable Integer project_id, Model model) {
        // make sure user can update this project
        return "students/projects/create";
    }

    @RequestMapping(value="/projects/{project_id}", method=RequestMethod.POST)
    public String update(@PathVariable Integer project_id, Model model) {
        // make sure user can update this project
        // update values
        return "redirect";
    }
}
