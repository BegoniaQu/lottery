package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 最近中奖信息
 * </p>
 *
 * @author quyang
 * @since 2018-04-09
 */
@TableName("latest_award_info")
public class LatestAwardInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 本期号
     */
    @TableField("current_term_num")
    private Integer currentTermNum;
    /**
     * 下期号
     */
    @TableField("next_term_num")
    private Integer nextTermNum;
    /**
     * 下期开奖时间
     */
    @TableField("next_term_time")
    private String nextTermTime;
    /**
     * 本次中奖数字
     */
    @TableField("award_nums")
    private String awardNums;
    /**
     * 生肖
     */
    private String sx;
    @TableField("create_time")
    private Date createTime;

    @TableField("next_term_date")
    private String nextTermDate;

    @TableField("next_term_hm")
    private String nextTermHm;

    @TableField("his_id")
    private Long hisId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCurrentTermNum() {
        return currentTermNum;
    }

    public void setCurrentTermNum(Integer currentTermNum) {
        this.currentTermNum = currentTermNum;
    }

    public Integer getNextTermNum() {
        return nextTermNum;
    }

    public void setNextTermNum(Integer nextTermNum) {
        this.nextTermNum = nextTermNum;
    }

    public String getNextTermTime() {
        return nextTermTime;
    }

    public void setNextTermTime(String nextTermTime) {
        this.nextTermTime = nextTermTime;
    }

    public String getAwardNums() {
        return awardNums;
    }

    public void setAwardNums(String awardNums) {
        this.awardNums = awardNums;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNextTermDate() {
        return nextTermDate;
    }

    public void setNextTermDate(String nextTermDate) {
        this.nextTermDate = nextTermDate;
    }

    public String getNextTermHm() {
        return nextTermHm;
    }

    public void setNextTermHm(String nextTermHm) {
        this.nextTermHm = nextTermHm;
    }

    public Long getHisId() {
        return hisId;
    }

    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }
}
