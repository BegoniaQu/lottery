package com.homedo.as.bean.respBean;

public class AppBaseSingleRespBean {

    private Long id;
    private String appId;
    private String appName;
    private Long categoryId;
    private Long arrayId;
    private String announceCtn;
    private String homePageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getArrayId() {
        return arrayId;
    }

    public void setArrayId(Long arrayId) {
        this.arrayId = arrayId;
    }

    public String getAnnounceCtn() {
        return announceCtn;
    }

    public void setAnnounceCtn(String announceCtn) {
        this.announceCtn = announceCtn;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }
}
