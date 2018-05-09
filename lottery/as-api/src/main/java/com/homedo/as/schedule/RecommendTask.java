package com.homedo.as.schedule;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.entity.RecommendInfo;
import com.homedo.as.service.RecommendInfoService;
import com.pub.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by quyang on 2018/4/12.
 */
@Component
public class RecommendTask {

    private static final Logger log = LoggerFactory.getLogger(RecommendTask.class);

    @Autowired
    private RecommendInfoService recommendInfoService;
    @Autowired
    private BusiConfig busiConfig;


    //@Scheduled(cron = "0 27 9 * * ?")
    public void work(){
        log.info("Start RecommendTask");
        int cnt = 0;
        try {
            while (cnt< 100) {
                int year = LocalDate.now().getYear();
                Map<String, String> params = new HashMap<>();
                params.put("client_lang", "zh-tw");
                params.put("year", String.valueOf(year));
                params.put("period", "200");
                String jsonStr = HttpUtils.doGet(busiConfig.getRecommendUrl(), params);
                Optional<String> optional = Optional.ofNullable(jsonStr);
                if (!optional.isPresent()) {//获取没成功，不再获取
                    return;
                }
                JsonElement jsonElement = new JsonParser().parse(optional.get());
                JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("betData");
                Iterator<JsonElement> iterator = jsonArray.iterator();
                if (iterator.hasNext()){
                    JsonObject jo = iterator.next().getAsJsonObject();
                    boolean existed = this.recommendInfoService.existByTime(jo.get("t").getAsString());
                    if (existed) { //存在，则没有新数据
                        log.info("not new data found this time");
                        TimeUnit.MINUTES.sleep(5);
                        cnt++;
                    }else{
                        RecommendInfo newOne = new RecommendInfo();
                        newOne.setTime(jo.get("t").getAsString());
                        newOne.setPeriodNum(jo.get("p").getAsInt());
                        newOne.setData(jo.getAsJsonArray("d").toString());
                        this.recommendInfoService.addRecommendInfo(newOne);
                        break;
                    }
                }
            }
        }catch (Exception e){
            log.error("RecommendTask error", e);
        }
        log.info("End RecommendTask");
    }
}
