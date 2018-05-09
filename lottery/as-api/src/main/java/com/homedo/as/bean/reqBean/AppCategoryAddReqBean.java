package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by quyang on 2018/5/9.
 */
public class AppCategoryAddReqBean {

    @NotBlank(message = "请填写分类名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
