package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 六合统计
 * </p>
 *
 * @author quyang
 * @since 2018-04-19
 */
@TableName("lh_statistic")
public class LhStatistic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 期数:100、200、300
     */
    private Integer term;
    /**
     * 六合统计数据
     */
    @TableField("lh_data")
    private String lhData;
    /**
     * 正码尾数统计
     */
    @TableField("zw_data")
    private String zwData;
    /**
     * 特码尾数统计
     */
    @TableField("tw_data")
    private String twData;
    /**
     * 正码波色统计
     */
    @TableField("zbs_data")
    private String zbsData;
    /**
     * 特码波色统计
     */
    @TableField("tbs_data")
    private String tbsData;
    /**
     * 正码生肖统计
     */
    @TableField("zsx_data")
    private String zsxData;
    /**
     * 特码生肖统计
     */
    @TableField("tsx_data")
    private String tsxData;
    /**
     * 操作时间
     */
    @TableField("operate_time")
    private Date operateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getLhData() {
        return lhData;
    }

    public void setLhData(String lhData) {
        this.lhData = lhData;
    }

    public String getZwData() {
        return zwData;
    }

    public void setZwData(String zwData) {
        this.zwData = zwData;
    }

    public String getTwData() {
        return twData;
    }

    public void setTwData(String twData) {
        this.twData = twData;
    }

    public String getZbsData() {
        return zbsData;
    }

    public void setZbsData(String zbsData) {
        this.zbsData = zbsData;
    }

    public String getTbsData() {
        return tbsData;
    }

    public void setTbsData(String tbsData) {
        this.tbsData = tbsData;
    }

    public String getZsxData() {
        return zsxData;
    }

    public void setZsxData(String zsxData) {
        this.zsxData = zsxData;
    }

    public String getTsxData() {
        return tsxData;
    }

    public void setTsxData(String tsxData) {
        this.tsxData = tsxData;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "LhStatistic{" +
                ", id=" + id +
                ", term=" + term +
                ", lhData=" + lhData +
                ", zwData=" + zwData +
                ", twData=" + twData +
                ", zbsData=" + zbsData +
                ", tbsData=" + tbsData +
                ", zsxData=" + zsxData +
                ", tsxData=" + tsxData +
                ", operateTime=" + operateTime +
                "}";
    }


    public static final String TERM = "term";
}
