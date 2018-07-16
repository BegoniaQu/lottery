package com.homedo.as.bean;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.bean.respBean.*;
import com.homedo.as.config.PropertiesConfig;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.dto.AppBaseInfoDTO;
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


    public List<ArrayPageRespBean> appArrayConvert(List<AppArrayInfoDTO> list){
        List<ArrayPageRespBean> respBeanList = list.stream().map(t->{
            ArrayPageRespBean respBean = new ArrayPageRespBean();
            respBean.setId(t.getId());
            respBean.setArrayName(t.getArrayName());
            respBean.setOperator(t.getOperator());
            respBean.setRule(t.getRule());
            respBean.setRuleName(t.getRuleName());
            respBean.setLastUpdateTime(DateUtils.date2String(t.getCreateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
        return respBeanList;
    }


    public List<RulePageRespBean> ruleListConvert(List<AppArrayRuleInfo> list){
        return list.stream().map(t->{
            RulePageRespBean respBean = new RulePageRespBean();
            respBean.setId(t.getId());
            respBean.setName(t.getName());
            respBean.setContent(t.getRule());
            respBean.setOperator(t.getOperator());
            respBean.setLastModifiedTime(DateUtils.date2String(t.getLastUpdateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
    }


    public ArraySingleRespBean arrayConvert(AppArrayInfo appArrayInfo){
        ArraySingleRespBean respBean = new ArraySingleRespBean();
        respBean.setId(appArrayInfo.getId());
        respBean.setArrayName(appArrayInfo.getArrayName());
        respBean.setRuleId(appArrayInfo.getRuleId());
        return respBean;
    }

    public List<RuleRespBean> ruleConvert(List<AppArrayRuleInfo> list){
        return list.stream().map(t->{
            RuleRespBean respBean = new RuleRespBean();
            respBean.setId(t.getId());
            respBean.setName(t.getName());
            return respBean;
        }).collect(Collectors.toList());
    }

    public RuleSingleRespBean ruleConvert(AppArrayRuleInfo t){
        RuleSingleRespBean respBean = new RuleSingleRespBean();
        respBean.setId(t.getId());
        respBean.setRuleName(t.getName());
        respBean.setContent(t.getRule());
        return respBean;
    }

    public List<AppBasePageRespBean> appBaseConvert(List<AppBaseInfoDTO> list){
        return list.stream().map(t->{
            AppBasePageRespBean respBean = new AppBasePageRespBean();
            respBean.setId(t.getId());
            respBean.setAppId(t.getAppId());
            respBean.setAppName(t.getAppName());
            respBean.setAnnounceContent(t.getAnnounceContent());
            respBean.setArrayName(t.getArrayName());
            respBean.setCategoryName(t.getCategoryName());
            respBean.setHomePageUrl(t.getHomePageUrl());
            respBean.setOperator(t.getOperator());
            respBean.setOperateTime(DateUtils.date2String(t.getOperateTime(), DateUtils.formalPattern));
            return respBean;
        }).collect(Collectors.toList());
    }

    public List<CategoryRespBean> categoryAllConvert(List<AppCategoryInfo> list){
        return list.stream().map(t->{
            CategoryRespBean respBean = new CategoryRespBean();
            respBean.setId(t.getId());
            respBean.setName(t.getCategoryName());
            return respBean;
        }).collect(Collectors.toList());
    }

    public List<ArrayRespBean> arrayAllConvert(List<AppArrayInfo> list){
        return list.stream().map(t->{
            ArrayRespBean respBean = new ArrayRespBean();
            respBean.setId(t.getId());
            respBean.setName(t.getArrayName());
            return respBean;
        }).collect(Collectors.toList());
    }


    public AppBaseSingleRespBean appBaseConvert(AppBaseInfo t){
        AppBaseSingleRespBean respBean = new AppBaseSingleRespBean();
        respBean.setId(t.getId());
        respBean.setAppId(t.getAppId());
        respBean.setArrayId(t.getArrayId());
        respBean.setCategoryId(Long.parseLong(t.getAppCategoryIdPath()));
        respBean.setAppName(t.getAppName());
        respBean.setAnnounceCtn(t.getAnnounceContent());
        respBean.setHomePageUrl(t.getHomePageUrl());
        return respBean;
    }





    public LatestAwardRespBean latestAwardConvert(LatestAwardInfo latestAwardInfo){
        LatestAwardRespBean bean = new LatestAwardRespBean();
        bean.setCurrentTermNum(latestAwardInfo.getCurrentTermNum());
        bean.setNextTermTime(latestAwardInfo.getNextTermTime());
        //
        String [] nums = latestAwardInfo.getAwardNums().split(",");
        String [] sxs = latestAwardInfo.getSx().split(",");
        //
        List<LatestAwardRespBean.LatestBall> balls = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            LatestAwardRespBean.LatestBall ball = bean.new LatestBall();
            ball.setNum(nums[i]);
            ball.setSx(sxs[i]);
            ball.setColor(PropertiesConfig.getBs(num2String(Integer.parseInt(nums[i]))));
            balls.add(ball);
        }
        bean.setBalls(balls);
        return bean;
    }

    public HisAwardDetailRespBean hisAwardDetailConvert(HisAwardInfo hisAwardInfo){
        HisAwardDetailRespBean bean = new HisAwardDetailRespBean();
        bean.setCurrentTermNum(Integer.parseInt(hisAwardInfo.getTermNum()));
        //
        String [] nums = hisAwardInfo.getNumbers().split(",");
        String [] sxs = hisAwardInfo.getSx().split(",");
        String [] bss = hisAwardInfo.getBs().split(",");
        String [] wxs = hisAwardInfo.getWx().split(",");
        String [] jys = hisAwardInfo.getJy().split(",");
        //
        List<HisAwardDetailRespBean.HistoryDetailBall> balls = new ArrayList<>();
        List<String> zmList = new ArrayList<>();//正码数据
        for(int i = 0; i < nums.length;i++){
            HisAwardDetailRespBean.HistoryDetailBall ball = bean.new HistoryDetailBall();
            ball.setNum(nums[i]);
            ball.setSx(sxs[i]);
            ball.setColor(bss[i]);
            balls.add(ball);
            //正码分析 ：合数、五行、尾数、头数、段数、家野
            if(i< nums.length - 1){
                int zNum = Integer.parseInt(nums[i]);
                int heshu = getHeshu(zNum);
                String ds;
                if(heshu % 2 == 0){
                    ds = "双";
                }else{
                    ds = "单";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("合数(").append(heshu).append("合 , ").append(ds).append(")");
                sb.append("、").append(wxs[i]);
                sb.append("、").append(num2String(zNum).substring(1)).append("尾");
                sb.append("、").append(getToushu(num2String(zNum)));
                sb.append("、").append(PropertiesConfig.getDs(num2String(zNum)));
                sb.append("、").append(jys[i]);
                zmList.add(sb.toString());
            }
        }
        bean.setBalls(balls);
        //特码分析
        HisAwardDetailRespBean.HisTDetail hisTDetail = bean.new HisTDetail();
        int tNum = Integer.parseInt(nums[nums.length - 1]);
        int heshu = getHeshu(tNum);
        if(heshu % 2 == 0){
            hisTDetail.setHsds("双");
        }else{
            hisTDetail.setHsds("单");
        }
        hisTDetail.setThs(heshu + "合");
        hisTDetail.setTwx(wxs[nums.length - 1]);
        hisTDetail.setTjy(jys[nums.length - 1]);
        hisTDetail.setTdx(tNum <= 24 ? "小":"大");
        hisTDetail.setTds(PropertiesConfig.getDs(num2String(tNum)));
        hisTDetail.setTts(getToushu(num2String(tNum)));
        hisTDetail.setWsdx(PropertiesConfig.getWs(num2String(tNum)));
        bean.setHisTDetail(hisTDetail);
        bean.setpDetail(zmList);
        return bean;
    }


    public LatestAwardDetailRespBean latestAwardDetailConvert(LatestAwardInfo latestAwardInfo){
        LatestAwardDetailRespBean bean = new LatestAwardDetailRespBean();
        bean.setCurrentTermNum(latestAwardInfo.getCurrentTermNum());
        bean.setNextTermTime(latestAwardInfo.getNextTermTime());
        //
        String [] nums = latestAwardInfo.getAwardNums().split(",");
        String [] sxs = latestAwardInfo.getSx().split(",");
        //
        List<LatestAwardDetailRespBean.LatestDetailBall> balls = new ArrayList<>();
        List<String> zmList = new ArrayList<>();//正码数据
        for(int i = 0; i < nums.length;i++){
            LatestAwardDetailRespBean.LatestDetailBall ball = bean.new LatestDetailBall();
            ball.setNum(nums[i]);
            ball.setSx(sxs[i]);
            ball.setColor(PropertiesConfig.getBs(num2String(Integer.parseInt(nums[i]))));
            balls.add(ball);
            //正码分析 ：合数、五行、尾数、头数、段数、家野
            if(i< nums.length - 1){
                int zNum = Integer.parseInt(nums[i]);
                int heshu = getHeshu(zNum);
                String ds;
                if(heshu % 2 == 0){
                    ds = "双";
                }else{
                    ds = "单";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("合数(").append(heshu).append("合 , ").append(ds).append(")");
                sb.append("、").append(PropertiesConfig.getWx(num2String(zNum)));
                sb.append("、").append(num2String(zNum).substring(1)).append("尾");
                sb.append("、").append(getToushu(num2String(zNum)));
                sb.append("、").append(PropertiesConfig.getDs(num2String(zNum)));
                sb.append("、").append(PropertiesConfig.getJy(sxs[i]));
                zmList.add(sb.toString());
            }
        }
        bean.setBalls(balls);
        //特码分析
        LatestAwardDetailRespBean.TDetail tDetail = bean.new TDetail();
        int tNum = Integer.parseInt(nums[nums.length - 1]);
        int heshu = getHeshu(tNum);
        if(heshu % 2 == 0){
            tDetail.setHsds("双");
        }else{
            tDetail.setHsds("单");
        }
        tDetail.setThs(heshu + "合");
        tDetail.setTwx(PropertiesConfig.getWx(num2String(tNum)));
        tDetail.setTjy(PropertiesConfig.getJy(sxs[sxs.length - 1]));
        tDetail.setTdx(tNum <= 24 ? "小":"大");
        tDetail.setTds(PropertiesConfig.getDs(num2String(tNum)));
        tDetail.setTts(getToushu(num2String(tNum)));
        tDetail.setWsdx(PropertiesConfig.getWs(num2String(tNum)));
        bean.settDetail(tDetail);
        bean.setpDetail(zmList);
        return bean;
    }

    public static int getHeshu(int num){
        int heshu;
        if(num < 10){
            heshu = num;
        }else{
            String tNumStr = String.valueOf(num);
            int one = Character.getNumericValue(tNumStr.charAt(0));
            int two = Character.getNumericValue(tNumStr.charAt(1));
            heshu = one + two;
        }
        return heshu;
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
            respBean.setId(t.getId());
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

    private String num2String(int num){
        return num < 10 ? ("0" + num) : "" + num;
    }

    private String getToushu(String num){
        int first = Character.getNumericValue(num.charAt(0));
        if(first == 0){
            return "0头";
        }
        if(first == 1){
            return "1头";
        }
        if(first == 2){
            return "2头";
        }
        if(first == 3){
            return "3头";
        }
        if(first == 4){
            return "4头";
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getHeshu(15));
    }
}
