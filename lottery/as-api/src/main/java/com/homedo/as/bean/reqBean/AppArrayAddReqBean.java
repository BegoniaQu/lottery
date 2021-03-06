package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by quyang on 2018/4/8.
 */
public class AppArrayAddReqBean {

    @NotBlank(message = "请填写组名称")
    private String arrayName;

    @NotNull(message = "请选择组规则")
    private Long ruleId;

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
}
