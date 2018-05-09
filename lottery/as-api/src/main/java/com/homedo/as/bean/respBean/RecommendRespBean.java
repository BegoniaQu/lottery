package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/12.
 */
@ApiModel
public class RecommendRespBean {

    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "时间")
    private String time;
    @ApiModelProperty(value = "推荐内容")
    private List<Item> items;

    @ApiModel
    public static class Item{
        @ApiModelProperty(value = "不知道啥意思")
        private String b;
        @ApiModelProperty(value = "不知道啥意思")
        private String r;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
