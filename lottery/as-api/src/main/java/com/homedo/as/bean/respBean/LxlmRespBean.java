package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/16.
 */
@ApiModel
public class LxlmRespBean {
    @ApiModelProperty(value = "期数")
    private String period;
    @ApiModelProperty(value = "号码")
    private List<String> nums;
    @ApiModelProperty(value = "生肖")
    private List<String> sxs;


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<String> getNums() {
        return nums;
    }

    public void setNums(List<String> nums) {
        this.nums = nums;
    }

    public List<String> getSxs() {
        return sxs;
    }

    public void setSxs(List<String> sxs) {
        this.sxs = sxs;
    }
}
