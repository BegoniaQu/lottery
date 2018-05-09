package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by quyang on 2018/4/27.
 */
public class AddBrocadesacReqBean {

    @NotBlank(message = "请填写期号")
    private String period;
    @NotBlank(message = "请填写内容")
    private String content;

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
