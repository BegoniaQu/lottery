package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by quyang on 2018/4/8.
 */
public class AppArrayAddReqBean {

    @NotBlank(message = "请填写组名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
