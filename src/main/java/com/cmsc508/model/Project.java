package com.cmsc508.model;

import java.util.Date;

public class Project {
    private long id;
    private long studentId;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getStudentId() {
        return studentId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
