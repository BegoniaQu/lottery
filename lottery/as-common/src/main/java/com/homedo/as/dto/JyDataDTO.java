package com.homedo.as.dto;

import java.time.LocalDate;

/**
 * Created by quyang on 2018/4/19.
 */
public class JyDataDTO extends BaseDTO{

    private int year = LocalDate.now().getYear();

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
