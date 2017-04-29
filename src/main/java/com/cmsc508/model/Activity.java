package com.cmsc508.model;

import java.util.Date;

/**
 * Created by Pulkit on 4/15/2017.
 */
public class Activity {
    private long id;
    private long studentId;
    private String type;
    private Date createdAt;
    private Date updatedAt;
    private String studentName;
    private int targetId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getTargetId() {
        return targetId;
    }
}
