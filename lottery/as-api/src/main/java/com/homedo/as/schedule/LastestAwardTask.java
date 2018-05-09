package com.homedo.as.schedule;

import com.homedo.as.bean.BeanConverter;
import com.homedo.as.bean.LatestBean;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.entity.LatestAwardInfo;
import com.homedo.as.service.LatestAwardInfoService;
import com.pub.HttpUtils;
import com.pub.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Created by quyang on 2018/4/9.
 */
@Component
public class LastestAwardTask {

    private static final Logger log = LoggerFactory.getLogger(LastestAwardTask.class);

    @Autowired
    private BusiConfig busiConfig;
    @Autowired
    private LatestAwardInfoService latestAwardInfoService;
    @Autowired
    private BeanConverter beanConverter;

    //@Scheduled(cron = "0/5 30-35 21 * * ?") //
    public void work() {
        log.info("Start LastestAwardTask");
        //System.out.println("执行调度任务："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        LatestAwardInfo dbOne = latestAwardInfoService.getLatestAwardInfo();
        try {
            String jsonStr = HttpUtils.doGet(busiConfig.getLatestAwardUrl(), null);
            Optional<String> optional = Optional.ofNullable(jsonStr);
            if(!optional.isPresent()){ //获取没成功，不再获取
                return;
            }
            LatestBean latestBean = JsonUtil.getObjectFromJson(optional.get(), LatestBean.class);
            if(dbOne.getCurrentTermNum() != latestBean.getId()){ //拿到最新数据
                beanConverter.box(dbOne, latestBean);
                latestAwardInfoService.updateLatestAwardInfo(dbOne);
            }else{
                log.info("not new data found this time");
            }
        } catch (Exception e) {
            log.error("LastestAwardTask error", e);
        }
        log.info("End LastestAwardTask");
    }






}
