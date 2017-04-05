package com.cmsc508.model;

public class Student {
    private long id;
    private String name;
    private String email;
    private String oauthUserId;
    private String shortDescription;
    private String githubUrl;
    private String linkedinUrl;
    private String websiteUrl;

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
