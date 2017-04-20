package com.cmsc508.model;

/**
 * Created by Pulkit on 4/15/2017.
 */
public class CourseAvailable {

    private long id;
    private long courseId;
    private String semester;
    private long year;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

}
