package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 历史中奖信息
 * </p>
 *
 * @author quyang
 * @since 2018-04-19
 */
@TableName("his_award_info")
public class HisAwardInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 期
     */
    private String period;
    /**
     * 中奖数字
     */
    private String numbers;
    /**
     * 生肖
     */
    private String sx;
    /**
     * 五行
     */
    private String wx;
    /**
     * 波色
     */
    private String bs;
    /**
     * 家野
     */
    private String jy;
    /**
     * 正码+特码 尾数大小
     */
    private String ws;

    /**
     * 总和数，七个号码相加
     */
    private Integer zh;
    /**
     * 2-总和双，1-总和单。就是7个号码加起来总数的尾数 是单就总和单，双就总和双
     */
    @TableField("zh_single")
    private Integer zhSingle;

    @TableField("create_time")
    private Date createTime;

    @TableField("term_num")
    private String termNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getJy() {
        return jy;
    }

    public void setJy(String jy) {
        this.jy = jy;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getZh() {
        return zh;
    }

    public void setZh(Integer zh) {
        this.zh = zh;
    }

    public Integer getZhSingle() {
        return zhSingle;
    }

    public void setZhSingle(Integer zhSingle) {
        this.zhSingle = zhSingle;
    }

    public String getTermNum() {
        return termNum;
    }

    public void setTermNum(String termNum) {
        this.termNum = termNum;
    }

    @Override
    public String toString() {
        return "HisAwardInfo{" +
                ", id=" + id +
                ", year=" + year +
                ", termNum=" + termNum +
                ", period=" + period +
                ", numbers=" + numbers +
                ", sx=" + sx +
                ", wx=" + wx +
                ", bs=" + bs +
                ", jy=" + jy +
                ", ws=" + ws +
                ", zh=" + zh +
                ", zhSingle=" + zhSingle +
                ", createTime=" + createTime +
                "}";
    }

    public static final String ID = "id";
    public static final String YEAR = "year";
}
