package com.homedo.as.schedule;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.homedo.as.bean.respBean.DataRespBean;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.entity.LhStatistic;
import com.homedo.as.service.LhStatisticService;
import com.pub.HttpUtils;
import com.pub.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by quyang on 2018/4/13.
 */
@Component
public class LhStatisticTask {
    private static final Logger log = LoggerFactory.getLogger(LhStatisticTask.class);

    @Autowired
    private LhStatisticService lhStatisticService;
    @Autowired
    private BusiConfig busiConfig;

    /**
     * 每日五点更新一次数据
     */
    @Scheduled(cron = "0 16 10 * * ?")
    public void work(){
        log.info("Start LhStatisticTask");
        try {
            List<Integer> terms = lhStatisticService.findTermField();

            terms.forEach(t->{
                long currentTime = System.currentTimeMillis();
                LhStatistic uptOne = new LhStatistic();
                uptOne.setTerm(t);
                //六合统计
                lhData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //正码尾数统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                zwData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //特码尾数统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                twData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //正码波色统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                zbsData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //特码波色统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                tbsData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //正码生肖统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                zsxData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                sleep_milli(500l);
                //特码生肖统计
                uptOne = new LhStatistic();
                uptOne.setTerm(t);
                tsxData(t.toString(), uptOne);
                this.lhStatisticService.updateLhStatisticByTerm(uptOne);
                long endTime = System.currentTimeMillis();
                log.info(t + "takes " + String.valueOf(endTime - currentTime) + " ms");
            });
        }catch (Exception e) {
            log.error("LhStatisticTask error", e);
        }
        log.info("End LhStatisticTask");
    }



    private void sleep_milli(Long milli){
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }

    /**
     *
     `lh_data`      '六合统计',
     `zw_data`      '正码尾数统计',
     `tw_data`      '特码尾数统计',
     `zbs_data`     '正码波色统计',
     `tbs_data`     '特码波色统计',
     `zsx_data`     '正码生肖统计',
     `tsx_data`     '特码生肖统计',
     * @param term
     * @param uptOne
     */

    private void lhData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getLhStatisticUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            uptOne.setLhData(optional.get());
        }
    }
    private void zwData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getZwDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setZwData(dataStr);
        }
    }

    private void twData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getTwDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setTwData(dataStr);
        }
    }

    private void zbsData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getZbsDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setZbsData(dataStr);
        }
    }
    private void tbsData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getTbsDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setTbsData(dataStr);
        }
    }
    private void zsxData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getZsxDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setZsxData(dataStr);
        }
    }
    private void tsxData(String term, LhStatistic uptOne){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("count", term);
        String jsonStr = HttpUtils.doGet(busiConfig.getTsxDataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if (optional.isPresent()) {
            String dataStr = JsonUtil.getJsonFromObject(convert(optional));
            uptOne.setTsxData(dataStr);
        }
    }



    private List<DataRespBean> convert(Optional<String> optional){
        List<DataRespBean> list = new ArrayList<>();
        JsonElement jsonElement = new JsonParser().parse(optional.get());
        String [] elems = jsonElement.getAsJsonObject().get("hotNum").getAsString().split(",");
        String [] hotDatas = jsonElement.getAsJsonObject().get("hotData").getAsString().split(",");
        String [] coolDatas = jsonElement.getAsJsonObject().get("omitData").getAsString().split(",");
        for(int i = 0;i<elems.length;i++){
            DataRespBean one = new DataRespBean();
            one.setEmt(elems[i]);
            one.setHotCnt(Integer.parseInt(hotDatas[i]));
            one.setColCnt(Integer.parseInt(coolDatas[i]));
            list.add(one);
        }
        return list;
    }
}
