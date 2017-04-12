package com.cmsc508.model;

import java.sql.Date;

public class Student {
    private long id;
    private String name;
    private String email;
    private String oauthUserId;
    private String shortDescription;
    private String githubUrl;
    private String linkedinUrl;
    private String websiteUrl;
    private Date createdAt;
    private Date updatedAt;

    public String getEmail() {
        return email;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public long getId() {
        return id;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public String getName() {
        return name;
    }

    public String getOauthUserId() {
        return oauthUserId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOauthUserId(String oauthUserId) {
        this.oauthUserId = oauthUserId;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
