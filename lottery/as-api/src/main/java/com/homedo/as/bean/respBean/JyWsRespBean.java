package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/20.
 */
@ApiModel
public class JyWsRespBean {

    @ApiModelProperty(value = "期")
    private String period;
    @ApiModelProperty(value = "大/小、家/野")
    private List<String> lst;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }
}
