package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 六合推荐
 * </p>
 *
 * @author quyang
 * @since 2018-04-10
 */
@TableName("recommend_info")
public class RecommendInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 时间
     */
    private String time;
    /**
     * 期号
     */
    @TableField("period_num")
    private Integer periodNum;
    /**
     * 推荐数据
     */
    private String data;
    @TableField("create_time")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(Integer periodNum) {
        this.periodNum = periodNum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RecommendInfo{" +
        "  id=" + id +
        ", time=" + time +
        ", periodNum=" + periodNum +
        ", data=" + data +
        ", createTime=" + createTime +
        "}";
    }

    public static final String ID = "id";
    public static final String TIME = "time";
    public static final String PERIODNUM= "period_num";
}
