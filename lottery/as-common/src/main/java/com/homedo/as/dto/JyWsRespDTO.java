package com.homedo.as.dto;

/**
 * Created by quyang on 2018/4/20.
 */
public class JyWsRespDTO {
    private String year;
    private String termNum;
    private String jy;
    private String ws;


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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTermNum() {
        return termNum;
    }

    public void setTermNum(String termNum) {
        this.termNum = termNum;
    }
}
