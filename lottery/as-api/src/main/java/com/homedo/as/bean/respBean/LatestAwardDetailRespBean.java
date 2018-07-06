package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/10.
 */
@ApiModel(description = "最新开奖数据详情")
public class LatestAwardDetailRespBean {

    @ApiModelProperty(value = "当前期数")
    private int currentTermNum; //当前期数
    @ApiModelProperty(value = "下次开奖时间")
    private String nextTermTime; //下次开奖时间

    @ApiModelProperty(value = "详情球信息")
    private List<LatestDetailBall> balls; //球

    @ApiModelProperty(value = "特码分析")
    private TDetail tDetail;

    @ApiModelProperty(value = "正码分析")
    private List<String> pDetail;




    @ApiModel(description = "详细球")
    public class LatestDetailBall {
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

    @ApiModel(description = "特码分析数据")
    public class TDetail{
        @ApiModelProperty(value = "合数单双")
        private String hsds;
        @ApiModelProperty(value = "特码大小")
        private String tdx;
        @ApiModelProperty(value = "特码五行")
        private String twx;
        @ApiModelProperty(value = "尾数大小")
        private String wsdx;
        @ApiModelProperty(value = "特码合数")
        private String ths;
        @ApiModelProperty(value = "特码段数")
        private String tds;
        @ApiModelProperty(value = "特码头数")
        private String tts;
        @ApiModelProperty(value = "特码家野")
        private String tjy;

        public String getHsds() {
            return hsds;
        }

        public void setHsds(String hsds) {
            this.hsds = hsds;
        }

        public String getTdx() {
            return tdx;
        }

        public void setTdx(String tdx) {
            this.tdx = tdx;
        }

        public String getTwx() {
            return twx;
        }

        public void setTwx(String twx) {
            this.twx = twx;
        }

        public String getWsdx() {
            return wsdx;
        }

        public void setWsdx(String wsdx) {
            this.wsdx = wsdx;
        }

        public String getThs() {
            return ths;
        }

        public void setThs(String ths) {
            this.ths = ths;
        }

        public String getTds() {
            return tds;
        }

        public void setTds(String tds) {
            this.tds = tds;
        }

        public String getTts() {
            return tts;
        }

        public void setTts(String tts) {
            this.tts = tts;
        }

        public String getTjy() {
            return tjy;
        }

        public void setTjy(String tjy) {
            this.tjy = tjy;
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

    public List<LatestDetailBall> getBalls() {
        return balls;
    }

    public void setBalls(List<LatestDetailBall> balls) {
        this.balls = balls;
    }

    public TDetail gettDetail() {
        return tDetail;
    }

    public void settDetail(TDetail tDetail) {
        this.tDetail = tDetail;
    }

    public List<String> getpDetail() {
        return pDetail;
    }

    public void setpDetail(List<String> pDetail) {
        this.pDetail = pDetail;
    }
}
