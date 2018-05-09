package com.homedo.as.dto;

/**
 * Created by quyang on 2018/4/12.
 */
public class RecommendDTO extends BaseDTO{

    private int pt = 0;//用来拉取最新数据（此处填写id）
    private int nt = 0;//用来获取下一页 (此处填写id)
    private int ps = 20; //page size

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }

    public int getNt() {
        return nt;
    }

    public void setNt(int nt) {
        this.nt = nt;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
}
