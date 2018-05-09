package com.homedo.as.dto;

import java.time.LocalDate;

/**
 * Created by quyang on 2018/4/11.
 */
public class HisBrocadeSacDTO extends BaseDTO{

    private int pt = 0;//用来拉取最新数据（此处填写id）
    private int nt = 0;//用来获取下一页 (此处填写id)
    private int ps = 20; //page size

    private int year = LocalDate.now().getYear();

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
