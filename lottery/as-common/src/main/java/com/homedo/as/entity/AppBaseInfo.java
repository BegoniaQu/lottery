package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * app配置信息
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
@TableName("app_base_info")
public class AppBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("app_id")
    private String appId;

    @TableField("app_name")
    private String appName;
    /**
     * 组ID
     */
    @TableField("array_id")
    private Long arrayId;
    /**
     * 分类path，多级分类逗号分隔
     */
    @TableField("app_category_id_path")
    private String appCategoryIdPath;
    /**
     * 广告id
     */
    @TableField("announce_content")
    private String announceContent;
    /**
     * 首页图片
     */
    @TableField("home_page_url")
    private String homePageUrl;
    /**
     * 操作人
     */
    private String operator;
    @TableField("create_time")
    private Date createTime;
    @TableField("last_update_time")
    private Date lastUpdateTime;


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

    public Long getArrayId() {
        return arrayId;
    }

    public void setArrayId(Long arrayId) {
        this.arrayId = arrayId;
    }

    public String getAppCategoryIdPath() {
        return appCategoryIdPath;
    }

    public void setAppCategoryIdPath(String appCategoryIdPath) {
        this.appCategoryIdPath = appCategoryIdPath;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    @Override
    public String toString() {
        return "AppBaseInfo{" +
        ", id=" + id +
        ", appId=" + appId +
        ", appName=" + appName +
        ", arrayId=" + arrayId +
        ", appCategoryIdPath=" + appCategoryIdPath +
        ", announceContent=" + announceContent +
        ", homePageUrl=" + homePageUrl +
        ", operator=" + operator +
        ", createTime=" + createTime +
        ", lastUpdateTime=" + lastUpdateTime +
        "}";
    }

    public static final String APPID = "app_id";
}
