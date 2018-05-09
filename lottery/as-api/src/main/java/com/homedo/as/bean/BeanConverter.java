package com.homedo.as.bean;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.bean.respBean.*;
import com.homedo.as.dto.JyWsRespDTO;
import com.homedo.as.dto.LxlmRespDTO;
import com.homedo.as.entity.*;
import com.pub.DateUtils;
import com.pub.JsonUtil;
import com.pub.bean.PageResult;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by quyang on 2018/4/8.
 */
@Component
public class BeanConverter {

    public PageResult<RecommendMgrRespBean> recommendConvert(Page<RecommendInfo> page){
        List<RecommendMgrRespBean> list = page.getRecords().stream().map(t->{
            RecommendMgrRespBean respBean = new RecommendMgrRespBean();
            respBean.setId(t.getId());
            respBean.setPeriodNum(t.getPeriodNum());
            respBean.setTime(t.getTime());
            List<RecommendItem> items = JsonUtil.getListFromJson(t.getData(), RecommendItem.class);
            final StringBuilder sb = new StringBuilder();
            items.stream().forEach(i->{
                sb.append(i.getB());
                if(!i.getR().equals("")){
                    sb.append("&nbsp;").append(i.getR()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
                }else{
                    sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                }
            });
            respBean.setContent(sb.toString());
            respBean.setCreateTime(DateUtils.date2String(t.getCreateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
        return new PageResult<>(list, page.getCurrent(), page.getSize(), page.getTotal());
    }

    public PageResult<BrocadesacMgrRespBean> brocadesacConvert(Page<BrocadeSacInfo> page){
        List<BrocadesacMgrRespBean> list = page.getRecords().stream().map(t->{
            BrocadesacMgrRespBean respBean = new BrocadesacMgrRespBean();
            respBean.setId(t.getId());
            respBean.setContent(t.getContent());
            respBean.setPeriod(t.getPeriod());
            respBean.setCreateTime(DateUtils.date2String(t.getCreateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
        return new PageResult<>(list, page.getCurrent(), page.getSize(), page.getTotal());
    }


    public PageResult<SxinfoRespBean> sxinfoConvert(Page<SxInfo> page){
        List<SxinfoRespBean> respBeans = page.getRecords().stream().map(t->{
            SxinfoRespBean respBean = new SxinfoRespBean();
            respBean.setId(t.getId());
            respBean.setYear(t.getYear());
            respBean.setSx(t.getSx());
            respBean.setNum(t.getNum());
            return respBean;
        }).collect(Collectors.toList());
        return new PageResult<>(respBeans, page.getCurrent(), page.getSize(), page.getTotal());
    }

    public PageResult<UserinfoRespBean> userInfoConvert(Page<UserInfo> page){
        List<UserinfoRespBean> respBeans = page.getRecords().stream().map(t->{
            UserinfoRespBean respBean = new UserinfoRespBean();
            respBean.setId(t.getId());
            respBean.setPhone(t.getPhone());
            respBean.setUsername(t.getUsername());
            respBean.setOperator(t.getOperator());
            respBean.setCreateTime(DateUtils.date2String(t.getOperateTime(), DateUtils.formalPattern));
            respBean.setRole(t.getRole() == 1 ? "管理员" : "普通用户");
            return respBean;
        }).collect(Collectors.toList());
        return new PageResult<>(respBeans, page.getCurrent(), page.getSize(), page.getTotal());
    }


    public HomeInfoRespBean homeInfoConvert(AppBaseInfo appBaseInfo){
        HomeInfoRespBean bean = new HomeInfoRespBean();
        bean.setAnnounce(appBaseInfo.getAnnounceContent());
        bean.setHomePageUrl(appBaseInfo.getHomePageUrl());
        return bean;
    }


    public List<AppArrayPageRespBean> appArrayConvert(List<AppArrayInfo> list){
        List<AppArrayPageRespBean> respBeanList = list.stream().map(t->{
            AppArrayPageRespBean respBean = new AppArrayPageRespBean();
            respBean.setId(t.getId());
            respBean.setArrayName(t.getArrayName());
            respBean.setOperator(t.getOperator());
            respBean.setCreateTime(DateUtils.date2String(t.getCreateTime(), DateUtils.formalPattern));
            respBean.setLastUpdateTime(DateUtils.date2String(t.getLastUpdateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
        return respBeanList;
    }


    public LatestAwardRespBean latestAwardConvert(LatestAwardInfo latestAwardInfo){
        LatestAwardRespBean bean = new LatestAwardRespBean();
        bean.setCurrentTermNum(latestAwardInfo.getCurrentTermNum());
        bean.setNextTermTime(latestAwardInfo.getNextTermTime());
        //
        String [] nums = latestAwardInfo.getAwardNums().split(",");
        String [] sxs = latestAwardInfo.getSx().split(",");
        //
        List<LatestAwardRespBean.Ball> balls = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            LatestAwardRespBean.Ball ball = bean.new Ball();
            ball.setNum(nums[i]);
            ball.setSx(sxs[i]);
            balls.add(ball);
        }
        bean.setBalls(balls);
        return bean;
    }


    public PageResult<AwardRespBean> awardConvert(Page<HisAwardInfo> page){
        List<AwardRespBean> respBeans = page.getRecords().stream().map(t->{
            AwardRespBean respBean = new AwardRespBean();
            respBean.setPeriod(t.getPeriod());
            respBean.setZh(t.getZh());
            respBean.setZhSingle(t.getZhSingle());
            respBean.setJy(t.getJy().replace(',',' '));
            respBean.setWs(t.getWs().replace(',',' '));
            respBean.setWx(t.getWx().replace(',',' '));
            respBean.setSx(t.getSx().replace(',',' '));
            String [] nums = t.getNumbers().split(",");
            String [] bss = t.getBs().split(",");
            List<AwardRespBean.Ball> balls = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                AwardRespBean.Ball ball = respBean.new Ball();
                ball.setNum(nums[i]);
                ball.setBs(bss[i]);
                balls.add(ball);
            }
            respBean.setBalls(balls);
            return respBean;
        }).collect(Collectors.toList());
        return new PageResult<>(respBeans, page.getCurrent(), page.getSize(), page.getTotal());
    }


    public List<HisAwardRespBean> hisAwardConvert(List<HisAwardInfo> list){
        return list.stream().map(t->{
            HisAwardRespBean respBean = new HisAwardRespBean();
            respBean.setPeriod(t.getPeriod());
            String [] nums = t.getNumbers().split(",");
            String [] wxs = t.getWx().split(",");
            String [] sxs = t.getSx().split(",");
            String [] bss = t.getBs().split(",");
            //
            List<HisAwardRespBean.Ball> balls = new ArrayList<>();
            for(int i=0;i<wxs.length;i++){
                HisAwardRespBean.Ball ball = respBean.new Ball();
                ball.setNum(nums[i]);
                ball.setSx(sxs[i]);
                ball.setWx(wxs[i]);
                ball.setBs(bss[i]);
                balls.add(ball);
            }
            respBean.setBalls(balls);
            return respBean;
        }).collect(Collectors.toList());
    }

    public List<LxlmRespBean> lxlmConvert(List<LxlmRespDTO> list){
        return list.stream().map(t->{
            LxlmRespBean respBean = new LxlmRespBean();
            respBean.setPeriod(t.getTermNum());
            if(t.getNumbers() != null){
                respBean.setNums(Arrays.asList(t.getNumbers().split(",")));
            }else if(t.getSx() != null){
                respBean.setSxs(Arrays.asList(t.getSx().split(",")));
            }
            return respBean;
        }).collect(Collectors.toList());
    }



    public List<HisBrocadeSacRespBean> hisBrocadeSacConvert(List<BrocadeSacInfo> list){
        return list.stream().map(t->{
            HisBrocadeSacRespBean respBean = new HisBrocadeSacRespBean();
            respBean.setId(t.getId());
            respBean.setContent(t.getContent());
            respBean.setPeriod(t.getPeriod());
            return respBean;
        }).collect(Collectors.toList());
    }


    public LatestBrocadeSacRespBean latestBrocadeSacConvert(BrocadeSacInfo brocadeSacInfo){
        LatestBrocadeSacRespBean respBean = new LatestBrocadeSacRespBean();
        respBean.setContent(brocadeSacInfo.getContent());
        respBean.setPeriod(brocadeSacInfo.getPeriod());
        return respBean;
    }

    public List<RecommendRespBean> recommendConvert(List<RecommendInfo> list){
        return list.stream().map(t->{
            RecommendRespBean respBean = new RecommendRespBean();
            respBean.setId(t.getId());
            respBean.setTime(t.getTime());
            List<RecommendRespBean.Item> items = JsonUtil.getObjectsFromJson(t.getData(), RecommendRespBean.Item.class);
            respBean.setItems(items);
            return respBean;
        }).collect(Collectors.toList());
    }


    public LhStatisticRespBean lhDataConvert(String lhData){
        return JsonUtil.getObjectFromJson(lhData, LhStatisticRespBean.class);
    }

    public List<DataRespBean> dataConvert(String data){
        return JsonUtil.getObjectsFromJson(data, DataRespBean.class);
    }


    public List<JyWsRespBean> jywsConvert(List<JyWsRespDTO> list){
        return list.stream().map(t->{
            JyWsRespBean jyWsRespBean = new JyWsRespBean();
            StringBuilder sb = new StringBuilder();
            sb.append(t.getYear()).append("-").append(t.getTermNum());
            jyWsRespBean.setPeriod(sb.toString());
            if(t.getJy() != null){
                jyWsRespBean.setLst(Arrays.asList(t.getJy().split(",")));
            }else if(t.getWs() != null){
                jyWsRespBean.setLst(Arrays.asList(t.getWs().split(",")));
            }
            return jyWsRespBean;
        }).collect(Collectors.toList());
    }


    public void box (LatestAwardInfo needDbOne, LatestBean latestBean){
        needDbOne.setCurrentTermNum(latestBean.getId());
        needDbOne.setNextTermNum(latestBean.getNextid());
        needDbOne.setNextTermTime(composeTime(latestBean));
        //处理数据
        List<String> maList = latestBean.getMa();
        List<String> numList = maList.stream().filter(t->isDigital(t)).collect(Collectors.toList());
        needDbOne.setAwardNums(StringUtils.arrayToDelimitedString(numList.toArray(), ","));
        List<String> chiList = maList.stream().filter(t->isChinese(t)).collect(Collectors.toList());
        needDbOne.setSx(StringUtils.arrayToDelimitedString(chiList.toArray(), ","));
        needDbOne.setCreateTime(new Date());
    }



    private String composeTime(LatestBean latestBean){
        StringBuilder sb = new StringBuilder();
        sb.append(latestBean.getYear()).append("年").append(latestBean.getDay()).append(latestBean.getTime()).append(latestBean.getWeek());
        return sb.toString();
    }
    private  boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find())
            flg = true;

        return flg;
    }
    private boolean isDigital(String str){
        Pattern pattern = Pattern.compile("^[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        String str = "野,家,野,家,野,家,野";
        System.out.println(str.replace(',', ' '));
    }
}
