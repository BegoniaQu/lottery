package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/10.
 */
@ApiModel
public class HisAwardRespBean {

    @ApiModelProperty(value = "期数")
    private String period;
    @ApiModelProperty(value = "开奖号码信息")
    private List<Ball> balls;

    @ApiModel
    public class Ball{
        @ApiModelProperty(value = "号码")
        private String num;
        @ApiModelProperty(value = "生肖")
        private String sx;
        @ApiModelProperty(value = "五行")
        private String wx;
        @ApiModelProperty(value = "波色")
        private String bs;


        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
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
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
