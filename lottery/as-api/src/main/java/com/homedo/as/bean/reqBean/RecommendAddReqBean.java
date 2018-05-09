package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by quyang on 2018/5/7.
 */
public class RecommendAddReqBean {

    @NotBlank(message ="请填写日期")
    private String time;
    @NotNull(message = "请填写期数")
    private Integer num;
    @NotBlank(message = "请填写内容")
    private String content;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
