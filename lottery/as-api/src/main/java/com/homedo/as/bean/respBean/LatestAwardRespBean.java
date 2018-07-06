package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/10.
 */
@ApiModel(description = "最新开奖数据详情")
public class LatestAwardRespBean {

    @ApiModelProperty(value = "当前期数")
    private int currentTermNum; //当前期数
    @ApiModelProperty(value = "下次开奖时间")
    private String nextTermTime; //下次开奖时间

    @ApiModelProperty(value = "开奖号信息")
    private List<LatestBall> balls; //球


    @ApiModel(description = "最新开奖球信息")
    public class LatestBall {
        @ApiModelProperty(value = "号")
        private String num;
        @ApiModelProperty(value = "生肖")
        private String sx;
        @ApiModelProperty(value = "波色")
        private String color;

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

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public int getCurrentTermNum() {
        return currentTermNum;
    }

    public void setCurrentTermNum(int currentTermNum) {
        this.currentTermNum = currentTermNum;
    }

    public String getNextTermTime() {
        return nextTermTime;
    }

    public void setNextTermTime(String nextTermTime) {
        this.nextTermTime = nextTermTime;
    }

    public List<LatestBall> getBalls() {
        return balls;
    }

    public void setBalls(List<LatestBall> balls) {
        this.balls = balls;
    }
}
