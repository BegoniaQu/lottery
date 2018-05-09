package com.homedo.as.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by quyang on 2018/4/9.
 */
@Configuration
@PropertySource("classpath:busi.properties")
@ConfigurationProperties(prefix = "lhc")
public class BusiConfig {

    private String historyDdataUrl; //历史开奖数据
    private String latestAwardUrl;  //最新开奖数据
    private String brocadeSacUrl;   //最新玄机锦囊
    private String hisBrocadeSacUrl;//历史玄机锦囊
    private String recommendUrl;    //六合推荐
    private String lhStatisticUrl;  //六合统计

    private String zwDataUrl; //正码尾数统计
    private String twDataUrl; //特码尾数统计

    private String zbsDataUrl; //正码波色统计
    private String tbsDataUrl; //特码波色统计

    private String zsxDataUrl; //正码生肖统计
    private String tsxDataUrl; //特码生肖统计


    public String getHistoryDdataUrl() {
        return historyDdataUrl;
    }

    public void setHistoryDdataUrl(String historyDdataUrl) {
        this.historyDdataUrl = historyDdataUrl;
    }

    public String getLatestAwardUrl() {
        return latestAwardUrl;
    }
    public void setLatestAwardUrl(String latestAwardUrl) {
        this.latestAwardUrl = latestAwardUrl;
    }

    public String getBrocadeSacUrl() {
        return brocadeSacUrl;
    }

    public void setBrocadeSacUrl(String brocadeSacUrl) {
        this.brocadeSacUrl = brocadeSacUrl;
    }

    public String getHisBrocadeSacUrl() {
        return hisBrocadeSacUrl;
    }

    public void setHisBrocadeSacUrl(String hisBrocadeSacUrl) {
        this.hisBrocadeSacUrl = hisBrocadeSacUrl;
    }

    public String getRecommendUrl() {
        return recommendUrl;
    }

    public void setRecommendUrl(String recommendUrl) {
        this.recommendUrl = recommendUrl;
    }

    public String getLhStatisticUrl() {
        return lhStatisticUrl;
    }

    public void setLhStatisticUrl(String lhStatisticUrl) {
        this.lhStatisticUrl = lhStatisticUrl;
    }

    public String getZwDataUrl() {
        return zwDataUrl;
    }

    public void setZwDataUrl(String zwDataUrl) {
        this.zwDataUrl = zwDataUrl;
    }

    public String getTwDataUrl() {
        return twDataUrl;
    }

    public void setTwDataUrl(String twDataUrl) {
        this.twDataUrl = twDataUrl;
    }

    public String getZbsDataUrl() {
        return zbsDataUrl;
    }

    public void setZbsDataUrl(String zbsDataUrl) {
        this.zbsDataUrl = zbsDataUrl;
    }

    public String getTbsDataUrl() {
        return tbsDataUrl;
    }

    public void setTbsDataUrl(String tbsDataUrl) {
        this.tbsDataUrl = tbsDataUrl;
    }

    public String getZsxDataUrl() {
        return zsxDataUrl;
    }

    public void setZsxDataUrl(String zsxDataUrl) {
        this.zsxDataUrl = zsxDataUrl;
    }

    public String getTsxDataUrl() {
        return tsxDataUrl;
    }

    public void setTsxDataUrl(String tsxDataUrl) {
        this.tsxDataUrl = tsxDataUrl;
    }
}
