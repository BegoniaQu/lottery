package com.homedo.as.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.bean.BeanConverter;
import com.homedo.as.bean.LoginUser;
import com.homedo.as.bean.reqBean.*;
import com.homedo.as.bean.respBean.*;
import com.homedo.as.config.PropertiesConfig;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.dto.AppBaseInfoDTO;
import com.homedo.as.entity.*;
import com.homedo.as.service.*;
import com.pub.DateUtils;
import com.pub.JsonUtil;
import com.pub.bean.PageResult;
import com.pub.exception.SCInvalidParamException;
import com.pub.exception.SCUnAuthorizedRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by quyang on 2018/4/24.
 */
@RestController
@RequestMapping("/mgr/")
public class DataController extends BaseController{

    @Autowired
    private BeanConverter beanConverter;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SxInfoService sxInfoService;
    @Autowired
    private HisAwardInfoService hisAwardInfoService;
    @Autowired
    private LatestAwardInfoService latestAwardInfoService;
    @Autowired
    private BrocadeSacInfoService brocadeSacInfoService;
    @Autowired
    private RecommendInfoService recommendInfoService;
    @Autowired
    private AppCategoryInfoService appCategoryInfoService;
    @Autowired
    private AppArrayInfoService appArrayInfoService;
    @Autowired
    private AppArrayRuleInfoService appArrayRuleInfoService;
    @Autowired
    private AppBaseInfoService appBaseInfoService;


    @GetMapping("/user/list")
    public PageResult<UserinfoRespBean> fingUserList(String phone, int offset, int limit){
        Page<UserInfo> page = userInfoService.findUserinfo(phone, limit, offset);
        return beanConverter.userInfoConvert(page);
    }

    @PostMapping("/user/add")
    public Object addUser(@Valid UserAddReqBean reqBean, HttpServletRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute("loginUser");
        if(!loginUser.isAdmin()){
            throw new SCUnAuthorizedRuntimeException("您无权此操作");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone(reqBean.getPhoneNum());
        userInfo.setPassword("123456");
        userInfo.setUsername(reqBean.getUserName());
        userInfo.setRole(reqBean.getType());
        userInfo.setOperator(loginUser.getUserName());
        userInfoService.addUser(userInfo);
        return "";
    }

    @GetMapping("/sx/list")
    public Object fingSxList(Integer year, int offset, int limit){
        if(year == null){
            year = LocalDate.now().getYear();
        }
        Page<SxInfo> page = this.sxInfoService.findSx(year, offset, limit);
        return beanConverter.sxinfoConvert(page);
    }

    @PostMapping("/sxcfg/add")
    public Object addSxConfig(@Valid SxcfgAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        int year = reqBean.getYear();
        List<SxInfo> list = new ArrayList<>();
        SxInfo sxInfoMa = new SxInfo();
        sxInfoMa.setYear(year);
        sxInfoMa.setSx(reqBean.getSxMa());
        sxInfoMa.setNum(reqBean.getNumMa().trim());
        list.add(sxInfoMa);

        SxInfo sxInfoLong = new SxInfo();
        sxInfoLong.setYear(year);
        sxInfoLong.setSx(reqBean.getSxLong());
        sxInfoLong.setNum(reqBean.getNumLong().trim());
        list.add(sxInfoLong);

        SxInfo sxInfoYang = new SxInfo();
        sxInfoYang.setYear(year);
        sxInfoYang.setSx(reqBean.getSxYang());
        sxInfoYang.setNum(reqBean.getNumYang().trim());
        list.add(sxInfoYang);

        SxInfo sxInfoGou = new SxInfo();
        sxInfoGou.setYear(year);
        sxInfoGou.setSx(reqBean.getSxGou());
        sxInfoGou.setNum(reqBean.getNumGou().trim());
        list.add(sxInfoGou);

        SxInfo sxInfoZhu = new SxInfo();
        sxInfoZhu.setYear(year);
        sxInfoZhu.setSx(reqBean.getSxZhu());
        sxInfoZhu.setNum(reqBean.getNumZhu().trim());
        list.add(sxInfoZhu);

        SxInfo sxInfoGi = new SxInfo();
        sxInfoGi.setYear(year);
        sxInfoGi.setSx(reqBean.getSxGi());
        sxInfoGi.setNum(reqBean.getNumGi().trim());
        list.add(sxInfoGi);

        SxInfo sxInfoTu = new SxInfo();
        sxInfoTu.setYear(year);
        sxInfoTu.setSx(reqBean.getSxTu());
        sxInfoTu.setNum(reqBean.getNumTu().trim());
        list.add(sxInfoTu);

        SxInfo sxInfoNiu = new SxInfo();
        sxInfoNiu.setYear(year);
        sxInfoNiu.setSx(reqBean.getSxNiu());
        sxInfoNiu.setNum(reqBean.getNumNiu().trim());
        list.add(sxInfoNiu);

        SxInfo sxInfoShe = new SxInfo();
        sxInfoShe.setYear(year);
        sxInfoShe.setSx(reqBean.getSxShe());
        sxInfoShe.setNum(reqBean.getNumShe().trim());
        list.add(sxInfoShe);

        SxInfo sxInfoHou = new SxInfo();
        sxInfoHou.setYear(year);
        sxInfoHou.setSx(reqBean.getSxHou());
        sxInfoHou.setNum(reqBean.getNumHou().trim());
        list.add(sxInfoHou);

        SxInfo sxInfoShu = new SxInfo();
        sxInfoShu.setYear(year);
        sxInfoShu.setSx(reqBean.getSxShu());
        sxInfoShu.setNum(reqBean.getNumShu().trim());
        list.add(sxInfoShu);

        SxInfo sxInfoHu = new SxInfo();
        sxInfoHu.setYear(year);
        sxInfoHu.setSx(reqBean.getSxHu());
        sxInfoHu.setNum(reqBean.getNumHu().trim());
        list.add(sxInfoHu);
        this.sxInfoService.addSxCfg(list);
        return "";
    }

    @PostMapping("/sxcfg/{id}/edit")
    public Object eidtSxNum(@PathVariable Long id, String num){
        SxInfo sxInfo = new SxInfo();
        sxInfo.setId(id);
        sxInfo.setNum(num);
        this.sxInfoService.updateSxNum(sxInfo);
        return "";
    }

    @GetMapping("/award/list")
    public Object findAwardList(Integer year, int offset, int limit){
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
        Page<HisAwardInfo> page = this.hisAwardInfoService.findByMgr(year, offset, limit);
        return beanConverter.awardConvert(page);
    }

    @PostMapping("/award/add")
    public Object addAward(@Valid AwardAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        LatestAwardInfo latestAwardInfo = new LatestAwardInfo();
        latestAwardInfo.setCurrentTermNum(reqBean.getTermNum());
        String [] dates = reqBean.getNextDate().split("-");
        StringBuilder sb = new StringBuilder().append(dates[0]).append("年").append(dates[1]).append("月").append(dates[2]).append("日");
        String []times = reqBean.getNextTime().split(" ");
        int hour;
        String [] hm = times[0].split(":");
        if(times[1].equals("PM")){
            hour = Integer.parseInt(hm[0])+unit;
        }else{
            hour = Integer.parseInt(hm[0]);
        }
        sb.append(hour).append("时").append(hm[1]).append("分");
        String week = DateUtils.getWeekString(reqBean.getNextDate(), DateUtils.simplePattern);
        sb.append(week);
        latestAwardInfo.setNextTermDate(reqBean.getNextDate());
        latestAwardInfo.setNextTermHm(reqBean.getNextTime());
        latestAwardInfo.setNextTermTime(sb.toString());
        List<Integer> nums = new ArrayList<>();
        nums.add(reqBean.getAwardNum1());
        nums.add(reqBean.getAwardNum2());
        nums.add(reqBean.getAwardNum3());
        nums.add(reqBean.getAwardNum4());
        nums.add(reqBean.getAwardNum5());
        nums.add(reqBean.getAwardNum6());
        nums.add(reqBean.getAwardNum7());
        List<String> numsStr = new ArrayList<>(); //小于10的号码要加个0
        numsStr.add(num2String(reqBean.getAwardNum1()));
        numsStr.add(num2String(reqBean.getAwardNum2()));
        numsStr.add(num2String(reqBean.getAwardNum3()));
        numsStr.add(num2String(reqBean.getAwardNum4()));
        numsStr.add(num2String(reqBean.getAwardNum5()));
        numsStr.add(num2String(reqBean.getAwardNum6()));
        numsStr.add(num2String(reqBean.getAwardNum7()));
        String numStr = StringUtils.collectionToDelimitedString(numsStr, ",");

        int currentYear = LocalDate.now().getYear();
        final List<SxInfo> sxInfos = sxInfoService.findSx(currentYear);
        List<String> sxs = nums.stream().map(t->getSx(sxInfos, t)).collect(Collectors.toList());
        latestAwardInfo.setAwardNums(StringUtils.collectionToDelimitedString(nums, ","));
        latestAwardInfo.setSx(StringUtils.collectionToDelimitedString(sxs, ","));
        //his
        HisAwardInfo hisAwardInfo = new HisAwardInfo();
        hisAwardInfo.setYear(currentYear);
        hisAwardInfo.setTermNum(termNum2String(reqBean.getTermNum()));
        hisAwardInfo.setPeriod(DateUtils.getCurrentYmdString() + hisAwardInfo.getTermNum() + "期");
        hisAwardInfo.setNumbers(numStr);
        hisAwardInfo.setSx(latestAwardInfo.getSx());
        hisAwardInfo.setWx(PropertiesConfig.getWx(numStr));
        hisAwardInfo.setBs(PropertiesConfig.getBs(numStr));
        hisAwardInfo.setJy(PropertiesConfig.getJy(latestAwardInfo.getSx()));
        hisAwardInfo.setWs(PropertiesConfig.getWs(numStr));
        hisAwardInfo.setZh(PropertiesConfig.sum(latestAwardInfo.getAwardNums()));
        hisAwardInfo.setZhSingle(PropertiesConfig.singleOrDouble(hisAwardInfo.getZh()));

        //
        LatestAwardInfo dbOne = this.latestAwardInfoService.getLatestAwardInfo();
        this.latestAwardInfoService.addLatestAwardInfo(latestAwardInfo, hisAwardInfo, dbOne);
        return "";
    }



    @GetMapping("/latestaward/show")
    public Object getLatestAward(){
        LatestAwardInfo latestAwardInfo = this.latestAwardInfoService.getLatestAwardInfo();
        AwardShowRespBean respBean = new AwardShowRespBean();
        respBean.setTermNum(latestAwardInfo.getCurrentTermNum());
        respBean.setNextDate(latestAwardInfo.getNextTermDate());
        respBean.setNextTime(latestAwardInfo.getNextTermHm());
        String [] nums = latestAwardInfo.getAwardNums().split(",");
        respBean.setAwardNum1(nums[0]);
        respBean.setAwardNum2(nums[1]);
        respBean.setAwardNum3(nums[2]);
        respBean.setAwardNum4(nums[3]);
        respBean.setAwardNum5(nums[4]);
        respBean.setAwardNum6(nums[5]);
        respBean.setAwardNum7(nums[6]);
        return respBean;
    }

    @GetMapping("/brocadesac/list")
    public Object findBrocadesac(String period, int offset, int limit){
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
        Page<BrocadeSacInfo> page = this.brocadeSacInfoService.find(period, offset, limit);
        return beanConverter.brocadesacConvert(page);
    }

    @PostMapping("/brocadesac/add")
    public Object addBrocadesac(@Valid AddBrocadesacReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        BrocadeSacInfo brocadeSacInfo = new BrocadeSacInfo();
        brocadeSacInfo.setPeriod(reqBean.getPeriod());
        brocadeSacInfo.setContent(reqBean.getContent());
        brocadeSacInfo.setYear(Integer.parseInt(reqBean.getPeriod().substring(0, 4)));
        this.brocadeSacInfoService.addBrocadeSacInfo(brocadeSacInfo);
        return "";
    }

    @GetMapping("/recommend/list")
    public Object findRecommend(Integer year, Integer periodNum, int offset, int limit){
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
        Page<RecommendInfo> page = this.recommendInfoService.find(year, periodNum ,offset, limit);
        return beanConverter.recommendConvert(page);
    }

    @PostMapping("/recommend/add")
    public Object addRecommend(@Valid RecommendAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }

        RecommendInfo recommendInfo = new RecommendInfo();
        String [] dates = reqBean.getTime().split("-");
        StringBuilder sb = new StringBuilder().append(dates[0]).append("年").append(dates[1]).append("月").append(dates[2]).append("日");
        recommendInfo.setTime(sb.toString());
        recommendInfo.setPeriodNum(reqBean.getNum());
        String content = reqBean.getContent().replaceAll("，", ",");//容忍中文逗号
        content = content.replaceAll("（", "(");//容忍中文括号
        String [] strs = content.split(",");
        List<RecommendItem> list = new ArrayList<>();
        for(String str : strs){
            RecommendItem item = new RecommendItem();
            if(str.contains("(")){
                str = str.substring(0, str.indexOf("("));
                item.setR("(中)");
            }else{
                item.setR("");
            }
            item.setB(str);
            list.add(item);
        }
        recommendInfo.setData(JsonUtil.getJsonFromObject(list));
        this.recommendInfoService.addRecommendInfo(recommendInfo);
        return "";
    }


    @GetMapping(value = "/array/list")
    public Object findAppArray(String arrayName, int offset, int limit){
        if(!StringUtils.isEmpty(arrayName)){
            arrayName = arrayName.trim();
        }
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
        Page<AppArrayInfoDTO> page = this.appArrayInfoService.page(arrayName, offset, limit);
        List<AppArrayPageRespBean> respList = beanConverter.appArrayConvert(page.getRecords());
        return new PageResult<>(respList, page.getCurrent(), page.getSize(), page.getTotal());
    }


    @PostMapping("/array/add")
    public Object addAppArrayInfo(@Valid AppArrayAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AppArrayInfo one = new AppArrayInfo();
        one.setArrayName(reqBean.getArrayName());
        one.setRuleId(reqBean.getRuleId());
        one.setOperator(getLongUser().getUserName());
        appArrayInfoService.addAppArrayInfo(one);
        return "";
    }

    @GetMapping(value = "/array/show")
    public Object getArray(@RequestParam Long id){
        AppArrayInfo appArrayInfo = this.appArrayInfoService.getById(id);
        return beanConverter.arrayConvert(appArrayInfo);
    }

    @PostMapping("/array/edit")
    public Object editAppArrayInfo(@Valid AppArrayEditReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AppArrayInfo appArrayInfo = this.appArrayInfoService.getById(reqBean.getId());
        if(appArrayInfo == null){
            throw new SCInvalidParamException("指定ID错误");
        }
        AppArrayInfo updateOne = new AppArrayInfo();
        updateOne.setId(reqBean.getId());
        updateOne.setOperator(getLongUser().getUserName());
        updateOne.setArrayName(reqBean.getArrayName());
        updateOne.setRuleId(reqBean.getRuleId());
        this.appArrayInfoService.updateAppArrayInfo(updateOne);
        return "";
    }

    @GetMapping(value = "/rule/all")
    public Object findRuleAll(){
        List<AppArrayRuleInfo> list = this.appArrayRuleInfoService.findAll();
        return beanConverter.ruleConvert(list);
    }

    @GetMapping(value = "/rule/show")
    public Object getRule(@RequestParam Long id){
        AppArrayRuleInfo appArrayRuleInfo = this.appArrayRuleInfoService.getById(id);
        return beanConverter.ruleConvert(appArrayRuleInfo);
    }

    @GetMapping(value = "/rule/list")
    public Object findRule(String ruleName, int offset, int limit){
        if(!StringUtils.isEmpty(ruleName)){
            ruleName = ruleName.trim();
        }
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
         Page<AppArrayRuleInfo> page = this.appArrayRuleInfoService.page(ruleName, offset, limit);
        List<RulePageRespBean> respList = beanConverter.ruleListConvert(page.getRecords());
        return new PageResult<>(respList, page.getCurrent(), page.getSize(), page.getTotal());
    }


    @PostMapping("/rule/add")
    public Object addRuleInfo(@Valid RuleAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AppArrayRuleInfo inserOne = new AppArrayRuleInfo();
        inserOne.setName(reqBean.getRuleName());
        inserOne.setRule(reqBean.getContent());
        inserOne.setOperator(getLongUser().getUserName());
        appArrayRuleInfoService.addRuleInfo(inserOne);
        return "";
    }


    @PostMapping("/rule/edit")
    public Object editRuleInfo(@Valid RuleEditReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AppArrayRuleInfo ruleInfo = this.appArrayRuleInfoService.getById(reqBean.getId());
        if(ruleInfo == null){
            throw new SCInvalidParamException("指定ID错误");
        }
        AppArrayRuleInfo updateOne = new AppArrayRuleInfo();
        updateOne.setId(reqBean.getId());
        updateOne.setOperator(getLongUser().getUserName());
        updateOne.setRule(reqBean.getContent());
        updateOne.setName(reqBean.getRuleName());
        this.appArrayRuleInfoService.updateRuleInfo(updateOne);
        return "";
    }


    @GetMapping("appbase/list")
    public Object findAppInfo(Long arrayId, Long categoryId, String appId, int offset, int limit){
        if(!StringUtils.isEmpty(appId)){
            appId = appId.trim();
        }
        if(offset == 0){
            offset = 1;
        }else{
            offset = (offset/10) +1;
        }
        Page<AppBaseInfoDTO> page = this.appBaseInfoService.page(arrayId, categoryId, appId, offset, limit);
        List<AppBasePageRespBean> respList = beanConverter.appBaseConvert(page.getRecords());
        return new PageResult<>(respList, page.getCurrent(), page.getSize(), page.getTotal());
    }





    @PostMapping("/category/add")
    public Object addCategory(@Valid AppCategoryAddReqBean reqBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SCInvalidParamException(bindingResult.getFieldError().getDefaultMessage());
        }
        AppCategoryInfo appCategoryInfo = new AppCategoryInfo();
        appCategoryInfo.setCategoryName(reqBean.getName());
        this.appCategoryInfoService.addCategory(appCategoryInfo);
        return "";
    }

    @GetMapping("category/all")
    public Object findCategoryAll(){
        List<AppCategoryInfo> list = this.appCategoryInfoService.finalAll();
        return beanConverter.categoryAllConvert(list);
    }

    @GetMapping("array/all")
    public Object findArrayAll(){
        List<AppArrayInfo> list = this.appArrayInfoService.findAll();
        return beanConverter.arrayAllConvert(list);
    }




    private String num2String(int num){
        return num < 10 ? ("0" + num) : "" + num;
    }


    private String termNum2String(int termNum){
        String str = termNum + "";
        if(termNum < 10){
            str = "00" + termNum;
        }else if(termNum>=10 && termNum < 100){
            str = "0" + termNum;
        }
        return str;
    }


    private String getSx(List<SxInfo> sxInfos, int num){
        String sx = null;
        for(SxInfo one : sxInfos){
            String [] nums = one.getNum().split(" ");
            for(String str : nums){
                if(Integer.parseInt(str) == num){
                    sx = one.getSx();
                    break;
                }
            }
            if(sx != null){
                break;
            }
        }
        return sx;
    }

    private static final int unit = 12;

}
