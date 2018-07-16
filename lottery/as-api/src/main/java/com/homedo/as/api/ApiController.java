package com.homedo.as.api;

import com.homedo.as.bean.BeanConverter;
import com.homedo.as.bean.respBean.*;
import com.homedo.as.config.BusiConfig;
import com.homedo.as.config.PropertiesConfig;
import com.homedo.as.dto.*;
import com.homedo.as.entity.*;
import com.homedo.as.manager.DataManager;
import com.homedo.as.service.*;
import com.pub.Request2PojoConverter;
import com.pub.exception.SCInvalidParamException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by quyang on 2018/4/10.
 */
@Api(description = "APP 开放接口")
@RestController
@RequestMapping("/api")
public class ApiController {
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
    @Autowired
    private AppBaseInfoService appBaseInfoService;
    @Autowired
    private DicInfoService dicInfoService;
    @Autowired
    private AppArrayRuleInfoService appArrayRuleInfoService;
    @Autowired
    private AppArrayInfoService appArrayInfoService;


    @ApiOperation(value="根据appId获取组配置信息", response = String.class, produces = "application/json")
    @GetMapping("/app/config")
    public Object getConfig(@ApiParam(required = true) @RequestParam("appId") String appId){
        AppBaseInfo appBaseInfo =  appBaseInfoService.getByAppId(appId);
        if(appBaseInfo != null){
            Long arrayId = appBaseInfo.getArrayId();
            if(arrayId != null){
                AppArrayInfo appArrayInfo = this.appArrayInfoService.getById(arrayId);
                if(appArrayInfo != null){
                    AppArrayRuleInfo appArrayRuleInfo = appArrayRuleInfoService.getById(appArrayInfo.getRuleId());
                    if(appArrayRuleInfo != null){
                        return appArrayRuleInfo.getRule();
                    }
                }
            }
        }
        return "";
    }


    @ApiOperation(value="获取首页信息", response = HomeInfoRespBean.class, produces = "application/json")
    @GetMapping("/home/info")
    public Object getHomeInfo(@ApiParam(required = true) @RequestParam String appId){
        //HomeDTO homeDTO = Request2PojoConverter.request2Pojo(request, HomeDTO.class);
        AppBaseInfo appBaseInfo = appBaseInfoService.getByAppId(appId);
        if(appBaseInfo != null){
            return beanConverter.homeInfoConvert(appBaseInfo);
        }
        return "";
    }


    @ApiOperation(value="获取搅珠图片", response = String.class, produces = "application/json")
    @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")
    @GetMapping("/jz/pic")
    public Object getJzPic(HttpServletRequest request){
        //JzPicDTO jzPicDTO = Request2PojoConverter.request2Pojo(request, JzPicDTO.class);
        DicInfo dicInfo = dicInfoService.getByKey(PropertiesConfig.JZ_PIC);
        if(dicInfo != null){
            return dicInfo.getValue();
        }
        return "";
    }



    @ApiOperation(value="获取最新开奖结果", response = LatestAwardRespBean.class, produces = "application/json")
    @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")
    @GetMapping("/award/latest")
    public Object getLatestAward(HttpServletRequest request){
        //LatestAwardDTO latestAwardDTO = Request2PojoConverter.request2Pojo(request, LatestAwardDTO.class);
        LatestAwardInfo latestAwardInfo = latestAwardInfoService.getLatestAwardInfo();
        return beanConverter.latestAwardConvert(latestAwardInfo);
    }

    @ApiOperation(value="获取最新开奖结果详情", response = LatestAwardDetailRespBean.class, produces = "application/json")
    @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")
    @GetMapping("/award/latest/detail")
    public Object getLatestAwardDetail(HttpServletRequest request){
        LatestAwardInfo latestAwardInfo = latestAwardInfoService.getLatestAwardInfo();
        return beanConverter.latestAwardDetailConvert(latestAwardInfo);
    }


    @ApiOperation(value="获取历史开奖结果详情", response = HisAwardDetailRespBean.class, produces = "application/json")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string"),
    @ApiImplicitParam(name = "id", value = "id" ,paramType = "query",dataType = "long")})
    @GetMapping("/award/history/detail")
    public Object getHistoryAwardDetail(@RequestParam Long id, HttpServletRequest request){
        HisAwardInfo one = hisAwardInfoService.getById(id);
        if(!Optional.ofNullable(one).isPresent()){
            throw new SCInvalidParamException("param error");
        }
        return beanConverter.hisAwardDetailConvert(one);
    }


    @ApiOperation(value="获取历史开奖结果", response = HisAwardRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/award/history")
    public Object findHissAward(HttpServletRequest request) {
        HisAwardDTO hisAwardDTO = Request2PojoConverter.request2Pojo(request, HisAwardDTO.class);
        List<HisAwardInfo> list = hisAwardInfoService.find(hisAwardDTO);
        return beanConverter.hisAwardConvert(list);
    }


    @ApiOperation(value="连码统计", response = LxlmRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/lm/data")
    public Object findLm(HttpServletRequest request){
        LmDTO lmDTO = Request2PojoConverter.request2Pojo(request, LmDTO.class);
        List<LxlmRespDTO> list = hisAwardInfoService.findLm(lmDTO);
        return beanConverter.lxlmConvert(list);
    }

    @ApiOperation(value="连肖统计", response = LxlmRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/lx/data")
    public Object findLx(HttpServletRequest request){
        LxDTO lxDTO = Request2PojoConverter.request2Pojo(request, LxDTO.class);
        List<LxlmRespDTO> list = hisAwardInfoService.findLx(lxDTO);
        return beanConverter.lxlmConvert(list);
    }


    @ApiOperation(value="玄机锦囊", response = LatestBrocadeSacRespBean.class, produces = "application/json")
    @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")
    @GetMapping("/brocadesac/latest")
    public Object getLatestBrocadeSac(HttpServletRequest request){
        //LatestBrocadeSacDTO latestAwardDTO = Request2PojoConverter.request2Pojo(request, LatestBrocadeSacDTO.class);
        BrocadeSacInfo brocadeSacInfo = brocadeSacInfoService.getLatest();
        return beanConverter.latestBrocadeSacConvert(brocadeSacInfo);

    }

    @ApiOperation(value="往期玄机锦囊", response = HisBrocadeSacRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "pt", value = "用来拉取最新数据（此处填写id）" ,paramType = "query"),
            @ApiImplicitParam(name = "nt", value = "用来获取下一页 (此处填写id)" ,paramType = "query"),
            @ApiImplicitParam(name = "ps", value = "page size" , paramType = "query")})
    @GetMapping("/brocadesac/history")
    public Object findHissBrocadeSac(HttpServletRequest request){
        HisBrocadeSacDTO hisAwardDTO = Request2PojoConverter.request2Pojo(request, HisBrocadeSacDTO.class);
        List<BrocadeSacInfo> list = this.brocadeSacInfoService.find(hisAwardDTO);
        return beanConverter.hisBrocadeSacConvert(list);
    }


    @ApiOperation(value="六合推荐", response = RecommendRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "pt", value = "用来拉取最新数据（此处填写id）" ,paramType = "query"),
            @ApiImplicitParam(name = "nt", value = "用来获取下一页 (此处填写id)" ,paramType = "query"),
            @ApiImplicitParam(name = "ps", value = "page size" , paramType = "query")})
    @GetMapping("/recommend/list")
    public Object findRecommend(HttpServletRequest request){
        RecommendDTO dto =  Request2PojoConverter.request2Pojo(request, RecommendDTO.class);
        List<RecommendInfo> list = this.recommendInfoService.find(dto);
        return beanConverter.recommendConvert(list);
    }


    @ApiOperation(value="六合统计", response = LhStatisticRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/lh/data")
    public Object findLhData(HttpServletRequest request){
        LhDataDTO lhDataDTO = Request2PojoConverter.request2Pojo(request, LhDataDTO.class);
        String lhData = lhStatisticService.getLhData(lhDataDTO);
        return beanConverter.lhDataConvert(lhData);
    }


    @ApiOperation(value="正码尾数统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/zw/data")
    public Object findZwData(HttpServletRequest request){
        ZwDataDTO zwDataDTO = Request2PojoConverter.request2Pojo(request, ZwDataDTO.class);
        String zwData = lhStatisticService.getZwData(zwDataDTO);
        return beanConverter.dataConvert(zwData);
    }


    @ApiOperation(value="特码尾数统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/tw/data")
    public Object findTwData(HttpServletRequest request){
        TwDataDTO twDataDTO = Request2PojoConverter.request2Pojo(request, TwDataDTO.class);
        String twData = lhStatisticService.getTwData(twDataDTO);
        return beanConverter.dataConvert(twData);
    }

    @ApiOperation(value="正码波色统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/zbs/data")
    public Object findZbsData(HttpServletRequest request){
        ZbsDataDTO zbsDataDTO = Request2PojoConverter.request2Pojo(request, ZbsDataDTO.class);
        String zbsData = lhStatisticService.getZbsData(zbsDataDTO);
        return beanConverter.dataConvert(zbsData);
    }

    @ApiOperation(value="特码波色统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string"),})
    @GetMapping("/tbs/data")
    public Object findTbsData(HttpServletRequest request){
        TbsDataDTO tbsDataDTO = Request2PojoConverter.request2Pojo(request, TbsDataDTO.class);
        String tbsData = lhStatisticService.getTbsData(tbsDataDTO);
        return beanConverter.dataConvert(tbsData);
    }

    @ApiOperation(value="生肖正码统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/zsx/data")
    public Object findZsxData(HttpServletRequest request){
        ZsxDataDTO zsxDataDTO = Request2PojoConverter.request2Pojo(request, ZsxDataDTO.class);
        String zsxData = lhStatisticService.getZsxData(zsxDataDTO);
        return beanConverter.dataConvert(zsxData);
    }

    @ApiOperation(value="生肖特码统计", response = DataRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "term", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/tsx/data")
    public Object findTsxData(HttpServletRequest request){
        TsxDataDTO tsxDataDTO = Request2PojoConverter.request2Pojo(request, TsxDataDTO.class);
        String tsxData = lhStatisticService.getTsxData(tsxDataDTO);
        return beanConverter.dataConvert(tsxData);
    }


    @ApiOperation(value="尾数大小统计", response = JyWsRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/ws/data")
    public Object findWsData(HttpServletRequest request){
        WsDataDTO wsDataDTO = Request2PojoConverter.request2Pojo(request, WsDataDTO.class);
        List<JyWsRespDTO> list = this.hisAwardInfoService.findWs(wsDataDTO);
        return beanConverter.jywsConvert(list);
    }

    @ApiOperation(value="家禽野兽统计", response = JyWsRespBean.class, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "多少期数统计", paramType = "query"),
            @ApiImplicitParam(name = "appId", value = "appID" ,paramType = "query",dataType = "string")})
    @GetMapping("/jy/data")
    public Object findJyData(HttpServletRequest request){
        JyDataDTO jyDataDTO = Request2PojoConverter.request2Pojo(request, JyDataDTO.class);
        List<JyWsRespDTO> list = this.hisAwardInfoService.findJy(jyDataDTO);
        return beanConverter.jywsConvert(list);
    }
}
