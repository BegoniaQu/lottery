package com.homedo.as.bean.respBean;


/**
 * Created by quyang on 2018/4/8.
 */
public class AppArrayPageRespBean {

    /**
     * 主键
     */
    private Long id;
    /**
     * 组名称
     */
    private String arrayName;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 更新时间
     */
    private String lastUpdateTime;

    private String rule;

    private String ruleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
