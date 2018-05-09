package com.homedo.as.schedule;

import com.homedo.as.bean.LatestBrocadeSacBean;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.entity.BrocadeSacInfo;
import com.homedo.as.service.BrocadeSacInfoService;
import com.pub.HttpUtils;
import com.pub.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by quyang on 2018/4/11.
 */

@Component
public class BrocadeSacTask {

    private static final Logger log = LoggerFactory.getLogger(BrocadeSacTask.class);

    @Autowired
    private BrocadeSacInfoService brocadeSacInfoService;
    @Autowired
    private BusiConfig busiConfig;


    //@Scheduled(cron = "0 35 21 * * ?")
    public void work(){
        log.info("Start BrocadeSacTask");
        int cnt = 0;
        try {
            while (cnt< 100) {
                String jsonStr = HttpUtils.doGet(busiConfig.getBrocadeSacUrl(), null);
                Optional<String> optional = Optional.ofNullable(jsonStr);
                if (!optional.isPresent()) {//获取没成功，不再获取
                    return;
                }
                LatestBrocadeSacBean latestBrocadeSacBean = JsonUtil.getObjectFromJson(optional.get(), LatestBrocadeSacBean.class);
                boolean existed = brocadeSacInfoService.existByPeriod(latestBrocadeSacBean.getPeriod());
                if (existed) { //存在，则没有新数据
                    log.info("not new data found this time");
                    TimeUnit.MINUTES.sleep(5);
                    cnt++;
                } else {
                    BrocadeSacInfo newOne = new BrocadeSacInfo();
                    newOne.setYear(LocalDate.now().getYear());
                    newOne.setPeriod(latestBrocadeSacBean.getPeriod());
                    newOne.setContent(latestBrocadeSacBean.getContent());
                    brocadeSacInfoService.addBrocadeSacInfo(newOne);
                    break;
                }
            }
        }catch (Exception e){
            log.error("BrocadeSacTask error", e);
        }
        log.info("End BrocadeSacTask");
    }
}
