package com.homedo.as.bean.respBean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by quyang on 2018/4/11.
 */
@ApiModel
public class HisBrocadeSacRespBean {

    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "期数")
    private String period;
    @ApiModelProperty(value = "内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
