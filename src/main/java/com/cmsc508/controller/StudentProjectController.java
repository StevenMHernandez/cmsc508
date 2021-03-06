package com.cmsc508.controller;

import com.cmsc508.model.Comment;
import com.cmsc508.model.Project;
import com.cmsc508.model.Star;
import com.cmsc508.model.Student;
import com.cmsc508.repository.CommentsRepository;
import com.cmsc508.repository.ProjectsRepository;
import com.cmsc508.repository.StarRepository;
import com.cmsc508.repository.StudentsRepository;

import org.springframework.http.MediaType;
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
        Student student = new StudentsRepository(this.jdbcTemplate).find(student_id);
        List<Project> projects = new ProjectsRepository(this.jdbcTemplate).findAllForStudent(student_id);
        List<Star> stars = new StarRepository(this.jdbcTemplate).getStarred(student_id);


        model.addAttribute("user", this.getStudent());
        model.addAttribute("student", student);
        model.addAttribute("projects", projects);
        model.addAttribute("stars", stars);

        return "students/projects/index";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}/star", method=RequestMethod.POST)
    public String storeStar(@PathVariable Integer project_id) {

        new StarRepository(this.jdbcTemplate).insertStarred(this.getStudent().getId(), project_id);

        return "redirect:/student/" + this.getStudent().getId() + "/projects";
    }

    @RequestMapping(value="/student/{student_id}/projects/", method=RequestMethod.GET)
    public String showStar(@PathVariable Integer project_id) {

        new StarRepository(this.jdbcTemplate).insertStarred(this.getStudent().getId(), project_id);

        return "redirect:/student/" + this.getStudent().getId() + "/projects";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model) {
        // get project data with comments and stars
        Project project = new ProjectsRepository(this.jdbcTemplate).get(project_id, student_id);
        List<Comment> comments = new CommentsRepository(this.jdbcTemplate).findForProject(project_id);

        model.addAttribute("project", project);
        model.addAttribute("comments", comments);
        model.addAttribute("user", this.getStudent());

        return "students/projects/show";
    }

    @RequestMapping(value="/student/{student_id}/projects/{project_id}/comment", method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String comment(@PathVariable Integer student_id, @PathVariable Integer project_id, Model model, String comment) {
        new CommentsRepository(this.jdbcTemplate).addForProject(project_id, this.getStudent().getId(), comment);
        return "redirect:/student/" + student_id + "/projects/" + project_id;
    }
}
