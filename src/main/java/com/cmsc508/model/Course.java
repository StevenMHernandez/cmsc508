package com.cmsc508.model;

/**
 * Created by Pulkit on 4/15/2017.
 */
public class Course {

    private long id;
    private String departmentId;
    private long courseNumber;
    private long instructorId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

}
