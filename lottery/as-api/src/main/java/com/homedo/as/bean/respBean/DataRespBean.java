package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by quyang on 2018/4/19.
 */
@ApiModel
public class DataRespBean {

    @ApiModelProperty(value = "数字/文字")
    private String emt; //元素
    @ApiModelProperty(value = "/出现次数")
    private int hotCnt; //出现次数
    @ApiModelProperty(value = "/遗漏期数")
    private int colCnt;//遗漏期数


    public String getEmt() {
        return emt;
    }

    public void setEmt(String emt) {
        this.emt = emt;
    }

    public int getHotCnt() {
        return hotCnt;
    }

    public void setHotCnt(int hotCnt) {
        this.hotCnt = hotCnt;
    }

    public int getColCnt() {
        return colCnt;
    }

    public void setColCnt(int colCnt) {
        this.colCnt = colCnt;
    }
}
