package com.homedo.as.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 生肖信息
 * </p>
 *
 * @author quyang
 * @since 2018-04-22
 */
@TableName("sx_info")
public class SxInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 生肖
     */
    private String sx;
    /**
     * 号码
     */
    private String num;


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

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SxInfo{" +
        ", id=" + id +
        ", year=" + year +
        ", sx=" + sx +
        ", num=" + num +
        "}";
    }

    public static final String YEAR = "year";

}
