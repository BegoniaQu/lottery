package com.homedo.as.bean;

import java.util.List;

/**
 * Created by quyang on 2018/4/9.
 */
public class ItemBean {

    private List<Data> items;

    public static class Data{

        private String period;
        private String numbers;
        private String sx;
        private String wx;

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getNumbers() {
            return numbers;
        }

        public void setNumbers(String numbers) {
            this.numbers = numbers;
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

    public List<Data> getItems() {
        return items;
    }

    public void setItems(List<Data> items) {
        this.items = items;
    }
}
