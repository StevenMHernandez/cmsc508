package com.cmsc508.model;

/**
 * Created by Pulkit on 4/15/2017.
 */
public class Star {


    private long studentId;
    private long projectId;
    private String projectName;
    private long projectStudentId;

    public long getProjectId() {
        return projectId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public long getProjectStudentId() {
        return projectStudentId;
    }

    public void setProjectStudentId(long projectStudentId) {
        this.projectStudentId = projectStudentId;
    }
}
