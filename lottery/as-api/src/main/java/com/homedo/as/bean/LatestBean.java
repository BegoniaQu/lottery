package com.homedo.as.bean;

import java.util.List;

/**
 * Created by quyang on 2018/4/9.
 */
public class LatestBean {
    private int id;
    private int nextid;
    private int year;
    private String day;
    private String time;
    private String week;
    // "id": 36,"nextid": 37,"year": 2018,"day": "04月10日","time": "21时30分","week": "星期二",

    private List<String> ma;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNextid() {
        return nextid;
    }

    public void setNextid(int nextid) {
        this.nextid = nextid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<String> getMa() {
        return ma;
    }

    public void setMa(List<String> ma) {
        this.ma = ma;
    }


}
