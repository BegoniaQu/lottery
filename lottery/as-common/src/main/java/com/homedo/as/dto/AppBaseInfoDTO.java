package com.homedo.as.dto;

import java.util.Date;

public class AppBaseInfoDTO {

    private Long id;

    private String appId;

    private String appName;
    /**
     * 组
     */
    private String arrayName;
    /**
     * 分类path，多级分类逗号分隔
     */
    private String categoryName;
    /**
     * 广告id
     */
    private String announceContent;
    /**
     * 首页图片
     */
    private String homePageUrl;
    /**
     * 操作人
     */
    private String operator;
    private Date operateTime;


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

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAnnounceContent() {
        return announceContent;
    }

    public void setAnnounceContent(String announceContent) {
        this.announceContent = announceContent;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
