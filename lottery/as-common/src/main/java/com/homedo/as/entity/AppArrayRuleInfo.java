package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 组与规则的关系
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
@TableName("app_rule_info")
public class AppArrayRuleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    /**
     * 规则
     */
    private String rule;
    /**
     * 0-失效，1-生效
     */
    private Integer status;
    /**
     * 操作人
     */
    private String operator;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("last_update_time")
    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "AppArrayRuleInfo{" +
        ", id=" + id +
        ", name=" + name +
        ", rule=" + rule +
        ", status=" + status +
        ", operator=" + operator +
        ", createTime=" + createTime +
        ", lastUpdateTime=" + lastUpdateTime +
        "}";
    }

    public static final String ARRAY_ID = "array_id";
    public static final String STATUS = "status";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATETIME = "create_time";
}
