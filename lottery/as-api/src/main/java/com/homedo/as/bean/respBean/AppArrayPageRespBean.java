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
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String lastUpdateTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
