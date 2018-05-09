package com.homedo.as.bean.respBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by quyang on 2018/4/13.
 */
@ApiModel
public class LhStatisticRespBean {

    @ApiModelProperty(value = "特码出现最多号")
    private List<Item> teMaReMen;          //特码出现最多号
    @ApiModelProperty(value = "特码遗漏最多号")
    private List<Item> teMaYiLou;          //特码遗漏最多号
    @ApiModelProperty(value = "正码出现最多号")
    private List<Item> danMaReMen;         //正码出现最多号
    @ApiModelProperty(value = "正码遗漏最多号")
    private List<Item> danMaYiLou;         //正码遗漏最多号
    @ApiModelProperty(value = "特码出现最多的生效")
    private List<Item> teMaSXReMen;        //特码出现最多的生效
    @ApiModelProperty(value = "特码遗漏最多的生效")
    private List<Item> teMaSXYiLou;        //特码遗漏最多的生效
    @ApiModelProperty(value = "正码出现最多的生效")
    private List<Item> danMaSXReMen;       //正码出现最多的生效
    @ApiModelProperty(value = "正码遗漏最多的生效")
    private List<Item> danMaSXYiLou;       //正码遗漏最多的生效
    @ApiModelProperty(value = "特码出现最多的波色")
    private List<Item> teMaSeBoReMen;      //特码出现最多的波色
    @ApiModelProperty(value = "特码遗漏最多的波色")
    private List<Item> teMaSeBoYiLou;      //特码遗漏最多的波色
    @ApiModelProperty(value = "正码出现最多的波色")
    private List<Item> danMaSeBoReMen;     //正码出现最多的波色
    @ApiModelProperty(value = "正码遗漏最多的波色")
    private List<Item> danMaSeBoYiLou;     //正码遗漏最多的波色
    @ApiModelProperty(value = "特码出现最多的尾数")
    private List<Item> teMaWeiShuReMen;    //特码出现最多的尾数
    @ApiModelProperty(value = "特码遗漏最多的尾数")
    private List<Item> teMaWeiShuYiLou;    //特码遗漏最多的尾数

    @ApiModel
    public static class Item{
        @ApiModelProperty(value = "球号码")
        private String name; //球号码
        @ApiModelProperty(value = "出现最多/最少")
        private int count; //出现最多/最少

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public List<Item> getTeMaReMen() {
        return teMaReMen;
    }

    public void setTeMaReMen(List<Item> teMaReMen) {
        this.teMaReMen = teMaReMen;
    }

    public List<Item> getTeMaYiLou() {
        return teMaYiLou;
    }

    public void setTeMaYiLou(List<Item> teMaYiLou) {
        this.teMaYiLou = teMaYiLou;
    }

    public List<Item> getDanMaReMen() {
        return danMaReMen;
    }

    public void setDanMaReMen(List<Item> danMaReMen) {
        this.danMaReMen = danMaReMen;
    }

    public List<Item> getDanMaYiLou() {
        return danMaYiLou;
    }

    public void setDanMaYiLou(List<Item> danMaYiLou) {
        this.danMaYiLou = danMaYiLou;
    }

    public List<Item> getTeMaSXReMen() {
        return teMaSXReMen;
    }

    public void setTeMaSXReMen(List<Item> teMaSXReMen) {
        this.teMaSXReMen = teMaSXReMen;
    }

    public List<Item> getTeMaSXYiLou() {
        return teMaSXYiLou;
    }

    public void setTeMaSXYiLou(List<Item> teMaSXYiLou) {
        this.teMaSXYiLou = teMaSXYiLou;
    }

    public List<Item> getDanMaSXReMen() {
        return danMaSXReMen;
    }

    public void setDanMaSXReMen(List<Item> danMaSXReMen) {
        this.danMaSXReMen = danMaSXReMen;
    }

    public List<Item> getDanMaSXYiLou() {
        return danMaSXYiLou;
    }

    public void setDanMaSXYiLou(List<Item> danMaSXYiLou) {
        this.danMaSXYiLou = danMaSXYiLou;
    }

    public List<Item> getTeMaSeBoReMen() {
        return teMaSeBoReMen;
    }

    public void setTeMaSeBoReMen(List<Item> teMaSeBoReMen) {
        this.teMaSeBoReMen = teMaSeBoReMen;
    }

    public List<Item> getTeMaSeBoYiLou() {
        return teMaSeBoYiLou;
    }

    public void setTeMaSeBoYiLou(List<Item> teMaSeBoYiLou) {
        this.teMaSeBoYiLou = teMaSeBoYiLou;
    }

    public List<Item> getDanMaSeBoReMen() {
        return danMaSeBoReMen;
    }

    public void setDanMaSeBoReMen(List<Item> danMaSeBoReMen) {
        this.danMaSeBoReMen = danMaSeBoReMen;
    }

    public List<Item> getDanMaSeBoYiLou() {
        return danMaSeBoYiLou;
    }

    public void setDanMaSeBoYiLou(List<Item> danMaSeBoYiLou) {
        this.danMaSeBoYiLou = danMaSeBoYiLou;
    }

    public List<Item> getTeMaWeiShuReMen() {
        return teMaWeiShuReMen;
    }

    public void setTeMaWeiShuReMen(List<Item> teMaWeiShuReMen) {
        this.teMaWeiShuReMen = teMaWeiShuReMen;
    }

    public List<Item> getTeMaWeiShuYiLou() {
        return teMaWeiShuYiLou;
    }

    public void setTeMaWeiShuYiLou(List<Item> teMaWeiShuYiLou) {
        this.teMaWeiShuYiLou = teMaWeiShuYiLou;
    }
}
