package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class RuleEditReqBean {

    @NotNull(message = "id undefined")
    private Long id;

    @NotBlank(message = "请填写规则名称")
    private String ruleName;

    @NotBlank(message = "请填写规则内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
