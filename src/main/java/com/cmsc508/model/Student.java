package com.cmsc508.model;

public class Student {
    private final long id;
    private final String name;
    private final String email;
    private final String oauthUserId;
    private final String shortDescription;
    private final String githubUrl;
    private final String linkedinUrl;
    private final String websiteUrl;

    public Student(String email, long id, String name, String oauthUserId, String shortDescription, String githubUrl, String linkedinUrl, String websiteUrl) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.oauthUserId = oauthUserId;
        this.shortDescription = shortDescription;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.websiteUrl = websiteUrl;
    }

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
}
