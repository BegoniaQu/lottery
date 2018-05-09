package com.homedo.as.bean.reqBean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by quyang on 2018/4/26.
 */
public class AwardAddReqBean {

    @NotNull(message = "请填写期数")
    private Integer termNum;
    @NotBlank(message = "请填写下次开奖日期")
    private String nextDate;
    @NotBlank(message = "请填写下次开奖时间")
    private String nextTime;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum1;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum2;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum3;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum4;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum5;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum6;
    @NotNull(message = "请填写开奖号码")
    private Integer awardNum7;


    public Integer getTermNum() {
        return termNum;
    }

    public void setTermNum(Integer termNum) {
        this.termNum = termNum;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public Integer getAwardNum1() {
        return awardNum1;
    }

    public void setAwardNum1(Integer awardNum1) {
        this.awardNum1 = awardNum1;
    }

    public Integer getAwardNum2() {
        return awardNum2;
    }

    public void setAwardNum2(Integer awardNum2) {
        this.awardNum2 = awardNum2;
    }

    public Integer getAwardNum3() {
        return awardNum3;
    }

    public void setAwardNum3(Integer awardNum3) {
        this.awardNum3 = awardNum3;
    }

    public Integer getAwardNum4() {
        return awardNum4;
    }

    public void setAwardNum4(Integer awardNum4) {
        this.awardNum4 = awardNum4;
    }

    public Integer getAwardNum5() {
        return awardNum5;
    }

    public void setAwardNum5(Integer awardNum5) {
        this.awardNum5 = awardNum5;
    }

    public Integer getAwardNum6() {
        return awardNum6;
    }

    public void setAwardNum6(Integer awardNum6) {
        this.awardNum6 = awardNum6;
    }

    public Integer getAwardNum7() {
        return awardNum7;
    }

    public void setAwardNum7(Integer awardNum7) {
        this.awardNum7 = awardNum7;
    }
}
