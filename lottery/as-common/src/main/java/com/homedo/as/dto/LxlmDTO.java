package com.homedo.as.dto;

import java.time.LocalDate;

/**
 * Created by quyang on 2018/4/16.
 */
public class LxlmDTO extends BaseDTO{

    private Integer year = LocalDate.now().getYear(); //默认是当前年

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
