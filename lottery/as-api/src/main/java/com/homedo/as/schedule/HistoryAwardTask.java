package com.homedo.as.schedule;

import com.homedo.as.bean.ItemBean;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.entity.HisAwardInfo;
import com.homedo.as.service.HisAwardInfoService;
import com.pub.HttpUtils;
import com.pub.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by quyang on 2018/4/9.
 */

@Component
public class HistoryAwardTask {

    private static final Logger log = LoggerFactory.getLogger(HistoryAwardTask.class);

    @Autowired
    private BusiConfig busiConfig;
    @Autowired
    private HisAwardInfoService hisAwardInfoService;


    //@Scheduled(cron = "0/15 30-35 21 * * ?")
    public void work(){
        log.info("Start HistoryAwardTask");
        HisAwardInfo dbOne = hisAwardInfoService.getLatest();
        int year = LocalDate.now().getYear();
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("year", String.valueOf(year));
        try {
            String jsonStr = HttpUtils.doGet(busiConfig.getHistoryDdataUrl(), params);
            Optional<String> optional = Optional.ofNullable(jsonStr);
            if (!optional.isPresent()) {//获取没成功，不再获取
                return;
            }
            ItemBean itemBean = JsonUtil.getObjectFromJson(optional.get(), ItemBean.class);
            ItemBean.Data data = itemBean.getItems().get(0);
            if (!data.getPeriod().equals(dbOne.getPeriod())) {
                HisAwardInfo newOne = new HisAwardInfo();
                newOne.setYear(year);
                newOne.setPeriod(data.getPeriod());
                newOne.setNumbers(data.getNumbers());
                newOne.setSx(data.getSx());
                newOne.setWx(data.getWx());
                this.hisAwardInfoService.addHisAwardInfo(newOne);
            } else {
                log.info("not new data found this time");
            }
        }catch (Exception e) {
            log.error("HistoryAwardTask error", e);
        }
        log.info("End HistoryAwardTask");
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now().getYear());
    }
}
