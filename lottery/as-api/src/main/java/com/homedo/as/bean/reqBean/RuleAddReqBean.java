package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

public class RuleAddReqBean {

    @NotBlank(message = "请填写规则名称")
    private String ruleName;

    @NotBlank(message = "请填写规则内容")
    private String content;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
