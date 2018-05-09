package com.homedo.as.bean.respBean;

import java.util.List;

/**
 * Created by quyang on 2018/4/26.
 */
public class AwardRespBean {

    private String period;
    private int zh;
    private int zhSingle;
    private String sx;
    private String wx;
    private String jy;
    private String ws;
    private List<Ball> balls;

    public class Ball{
        private String num;

        private String bs;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
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

    public int getZh() {
        return zh;
    }

    public void setZh(int zh) {
        this.zh = zh;
    }

    public int getZhSingle() {
        return zhSingle;
    }

    public void setZhSingle(int zhSingle) {
        this.zhSingle = zhSingle;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
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


}
