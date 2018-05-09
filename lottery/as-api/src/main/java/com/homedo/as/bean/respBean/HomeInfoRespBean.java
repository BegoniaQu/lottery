package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by quyang on 2018/4/20.
 */
@ApiModel
public class HomeInfoRespBean {

    @ApiModelProperty(value = "首页图片")
    private String homePageUrl;
    @ApiModelProperty(value = "广播信息")
    private String announce;

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }
}
