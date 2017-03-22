package com.cmsc508.model;

import java.util.Date;

public class Project {
    private final long id;
    private final long studentId;
    private final String name;
    private final String description;
    private final Date createdAt;
    private final Date updatedAt;

    public Project(Date createdAt, long id, long studentId, String name, String description, Date updatedAt) {
        this.createdAt = createdAt;
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.description = description;
        this.updatedAt = updatedAt;
    }

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
