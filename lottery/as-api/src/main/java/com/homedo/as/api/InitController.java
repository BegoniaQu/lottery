package com.homedo.as.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.homedo.as.bean.BeanConverter;
import com.homedo.as.bean.ItemBean;
import com.homedo.as.bean.LatestBean;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.config.PropertiesConfig;
import com.homedo.as.entity.BrocadeSacInfo;
import com.homedo.as.entity.HisAwardInfo;
import com.homedo.as.entity.LatestAwardInfo;
import com.homedo.as.entity.RecommendInfo;
import com.homedo.as.manager.DataManager;
import com.homedo.as.service.*;
import com.pub.HttpUtils;
import com.pub.JsonUtil;
import com.pub.exception.SCCustomRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by quyang on 2018/4/19.
 */
@RestController
@RequestMapping("/init")
public class InitController {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private BusiConfig busiConfig;
    @Autowired
    private BeanConverter beanConverter;
    @Autowired
    private LatestAwardInfoService latestAwardInfoService;
    @Autowired
    private HisAwardInfoService hisAwardInfoService;
    @Autowired
    private BrocadeSacInfoService brocadeSacInfoService;
    @Autowired
    private RecommendInfoService recommendInfoService;
    @Autowired
    private LhStatisticService lhStatisticService;


    @GetMapping("/award/latest/load")
    public Object loadLatestAwardData(){
        String jsonStr = HttpUtils.doGet(busiConfig.getLatestAwardUrl(), null);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if(!optional.isPresent()){
            throw new SCCustomRuntimeException("加载最新中奖数据失败");
        }
        LatestBean latestBean = JsonUtil.getObjectFromJson(optional.get(), LatestBean.class);
        LatestAwardInfo newOne = new LatestAwardInfo();
        beanConverter.box(newOne, latestBean);
        latestAwardInfoService.addLatestAwardInfo(newOne);
        return "ok";
    }

    @GetMapping("/award/history/{year}/load")
    public Object loadHisAwardData(@PathVariable Integer year){
        Map<String, String> params = new HashMap<>();
        params.put("client_lang", "zh-tw");
        params.put("year", year.toString());
        String jsonStr = HttpUtils.doGet(busiConfig.getHistoryDdataUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if(!optional.isPresent()){
            throw new SCCustomRuntimeException("加载历史中奖数据失败");
        }
        final List<HisAwardInfo> hisAwardInfoList = new ArrayList<>();
        ItemBean itemBean = JsonUtil.getObjectFromJson(optional.get(), ItemBean.class);
        itemBean.getItems().stream().forEach(p->{
            HisAwardInfo hisAwardInfo = new HisAwardInfo();
            hisAwardInfo.setYear(year);
            hisAwardInfo.setTermNum(p.getPeriod().substring(p.getPeriod().lastIndexOf("日") + 1, p.getPeriod().lastIndexOf("期")));
            hisAwardInfo.setPeriod(p.getPeriod());
            hisAwardInfo.setNumbers(p.getNumbers());
            hisAwardInfo.setSx(p.getSx());
            hisAwardInfo.setWx(p.getWx());
            //
            hisAwardInfo.setBs(PropertiesConfig.getBs(p.getNumbers()));
            hisAwardInfo.setJy(PropertiesConfig.getJy(p.getSx()));
            hisAwardInfo.setWs(PropertiesConfig.getWs(p.getNumbers()));
            hisAwardInfo.setZh(PropertiesConfig.sum(p.getNumbers()));
            hisAwardInfo.setZhSingle(PropertiesConfig.singleOrDouble(hisAwardInfo.getZh()));
            hisAwardInfoList.add(hisAwardInfo);
        });
        Collections.reverse(hisAwardInfoList);
        hisAwardInfoService.addHisAwardInfos(hisAwardInfoList);
        return "ok";
    }

    //只需加载2018年
    @GetMapping("/brocadesac/history/{year}/load")
    public Object loadHisBrocadeSacData(@PathVariable Integer year){
        Map<String, String> params = new HashMap<>();
        params.put("year", year.toString());
        params.put("page", "1");
        params.put("pageSize", "200");
        String jsonStr = HttpUtils.doGet(busiConfig.getHisBrocadeSacUrl(), params);
        Optional<String> optional = Optional.ofNullable(jsonStr);
        if(!optional.isPresent()){
            throw new SCCustomRuntimeException("加载历史锦囊数据失败");
        }
        List<BrocadeSacInfo> brocadeSacInfos = new ArrayList<>();
        JsonElement jsonElement = new JsonParser().parse(optional.get());
        JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("items");
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JsonObject jo = iterator.next().getAsJsonObject();
            BrocadeSacInfo one = new BrocadeSacInfo();
            one.setYear(year);
            one.setPeriod(jo.get("period").getAsString());
            one.setContent(jo.get("content").getAsString());
            brocadeSacInfos.add(one);
        }
        Collections.reverse(brocadeSacInfos);
        this.brocadeSacInfoService.addBrocadeSacInfos(brocadeSacInfos);
        return "ok";
    }

    //将测试库里的2018年前的数据到时候导到正式环境，最后在线上把2018年的数据调用此接口加载一次
    @GetMapping("/recommend/history/load")
    public Object loadRecommendData(@RequestParam("year") String year, @RequestParam("period") int period){
        List<RecommendInfo> recommendInfos = new ArrayList<>();
        while(period >= 1){
            Map<String, String> params = new HashMap<>();
            params.put("client_lang", "zh-tw");
            params.put("year", year);
            params.put("period", String.valueOf(period));
            String jsonStr = HttpUtils.doGet(busiConfig.getRecommendUrl(), params);
            Optional<String> optional = Optional.ofNullable(jsonStr);
            if(!optional.isPresent()){
                throw new SCCustomRuntimeException("加载六合推荐数据失败");
            }
            JsonElement jsonElement = new JsonParser().parse(optional.get());
            JsonArray jsonArray = jsonElement.getAsJsonObject().getAsJsonArray("betData");
            Iterator<JsonElement> iterator = jsonArray.iterator();
            int mark = 0;
            while (iterator.hasNext()){
                RecommendInfo one = new RecommendInfo();
                JsonObject jo = iterator.next().getAsJsonObject();
                if(mark == 0){
                    mark = jo.get("p").getAsInt();
                }
                if(jo.get("p").getAsInt() > mark){
                    break;
                }
                one.setTime(jo.get("t").getAsString());
                one.setPeriodNum(jo.get("p").getAsInt());
                one.setData(jo.getAsJsonArray("d").toString());
                recommendInfos.add(one);
            }
            period-=20;
        }
        Collections.reverse(recommendInfos);
        this.recommendInfoService.addRecommendInfos(recommendInfos);
        return "ok";
    }



}
