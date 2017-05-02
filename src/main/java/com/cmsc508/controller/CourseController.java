package com.cmsc508.controller;

import com.cmsc508.model.Course;
import com.cmsc508.model.Project;
import com.cmsc508.model.Student;
import com.cmsc508.repository.CoursesRepository;
import com.cmsc508.repository.ProjectsRepository;
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

        List<Student> students = new StudentsRepository(this.jdbcTemplate).findAllForCourse(course_id);
        model.addAttribute("students", students);

        Course course = new CoursesRepository(this.jdbcTemplate).find(course_id);
        model.addAttribute("courseNumber", course);

        List<Project> projects = new ProjectsRepository(this.jdbcTemplate).findAllForCourse(course_id);
        model.addAttribute("projects", projects);

        return "courses/show";
    }

    @RequestMapping(value="/courses/{course_id}", method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String delete(@PathVariable Integer course_id) {
        new CoursesRepository(this.jdbcTemplate).delete(this.getStudent().getId(), course_id);
        return "redirect:/courses/add";
    }
}
