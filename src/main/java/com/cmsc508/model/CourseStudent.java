package com.cmsc508.model;

/**
 * Created by Pulkit on 4/15/2017.
 */
public class CourseStudent {

    private long courseId;
    private long studentId;
    private String semester;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }


}
