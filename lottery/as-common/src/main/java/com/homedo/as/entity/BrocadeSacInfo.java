package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 玄机锦囊
 * </p>
 *
 * @author quyang
 * @since 2018-04-10
 */
@TableName("brocade_sac_info")
public class BrocadeSacInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 期
     */
    private String period;
    /**
     * 内容
     */
    private String content;

    @TableField("create_time")
    private Date createTime;
    /**
     * 年
     */
    private Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "BrocadeSacInfo{" +
        ", id=" + id +
        ", year=" + year +
        ", period=" + period +
        ", content=" + content +
        ", createTime=" + createTime +
        "}";
    }

    public static final String YEAR = "year";
    public static final String ID = "id";
    public static final String PERIOD = "period";
}
