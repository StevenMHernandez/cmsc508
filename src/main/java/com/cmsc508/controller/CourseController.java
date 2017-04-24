package com.cmsc508.controller;

import com.cmsc508.model.Course;
import com.cmsc508.repository.CoursesRepository;
import com.cmsc508.repository.StudentsRepository;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CourseController extends BaseController {
    @RequestMapping(value="/courses/add", method=RequestMethod.GET)
    public String index(Model model) {
        List<Course> studentCourses = new CoursesRepository(this.jdbcTemplate).findStudentCourses(this.getStudent().getId());
        List<Course> otherCourses = new CoursesRepository(this.jdbcTemplate).findNonStudentCourses(this.getStudent().getId());

        model.addAttribute("studentCourses", studentCourses);
        model.addAttribute("otherCourses", otherCourses);

        return "courses/add";
    }

    @RequestMapping(value="/courses/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String add(Model model, Integer courseId) {
        new StudentsRepository(this.jdbcTemplate).addCourse(this.getStudent().getId(), courseId);
        return "redirect:/courses/add";
    }

    @RequestMapping(value="/courses/{course_id}", method=RequestMethod.GET)
    public String show(@PathVariable Integer course_id, Model model) {
        // load course from database
        // get all students in the course
        // get all projects from students in the course
        return "courses/show";
    }
}
