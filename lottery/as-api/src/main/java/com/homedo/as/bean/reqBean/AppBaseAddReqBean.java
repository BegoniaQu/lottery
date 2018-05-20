package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class AppBaseAddReqBean {

    @NotBlank(message = "请填写appId")
    private String appId;

    private String appName;

    @NotNull(message = "请选择分类")
    private Long categoryId;
    @NotNull(message = "请选择组")
    private Long arrayId;


    private String announceCtn;

    @NotBlank(message = "请选择首页图")
    private String homePageUrl;

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
