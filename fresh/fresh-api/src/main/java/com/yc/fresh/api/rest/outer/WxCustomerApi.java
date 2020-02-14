package com.yc.fresh.api.rest.outer;

import com.yc.fresh.api.conf.AppConfig;
import com.yc.fresh.api.rest.inner.builder.LockNameBuilder;
import com.yc.fresh.api.rest.outer.convertor.CustomerConvertor;
import com.yc.fresh.api.rest.outer.req.bean.RegisterReqBean;
import com.yc.fresh.api.rest.outer.resp.bean.AuthenRespBean;
import com.yc.fresh.api.rest.outer.resp.bean.RegisterRespBean;
import com.yc.fresh.busi.CustomerManager;
import com.yc.fresh.busi.enums.LoginEnum;
import com.yc.fresh.busi.validator.CustomerValidator;
import com.yc.fresh.common.cache.lock.impl.LockProxy;
import com.yc.fresh.common.exception.SCApiRuntimeException;
import com.yc.fresh.common.lock.DistributedLock;
import com.yc.fresh.common.tp.WxRequester;
import com.yc.fresh.common.tp.bean.WxAuthInfo;
import com.yc.fresh.common.utils.DateUtils;
import com.yc.fresh.service.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by quy on 2019/11/28.
 * Motto: you can do it
 */
@RestController
@RequestMapping("/rest/outer/wx/c")
@Api(description = "小程序顾客服务")
public class WxCustomerApi {

    private final CustomerManager customerManager;
    private final AppConfig appConfig;
    private final DistributedLock<LockProxy> distributedLock;

    @Autowired
    public WxCustomerApi(CustomerManager customerManager, AppConfig appConfig, DistributedLock<LockProxy> distributedLock) {
        this.customerManager = customerManager;
        this.appConfig = appConfig;
        this.distributedLock = distributedLock;
    }

    @PostMapping("/reg")
    @ApiOperation(value="注册用户", produces=APPLICATION_JSON_VALUE, httpMethod = "POST")
    public RegisterRespBean register(@Valid @RequestBody RegisterReqBean reqBean, HttpServletRequest request) {
        String openid = (String)request.getAttribute("openid");
        String lockName = LockNameBuilder.buildOpenid(openid);
        LockProxy lock = distributedLock.lock(lockName);
        if (lock == null) { throw new SCApiRuntimeException(); }
        UserInfo t = customerManager.get(openid);
        Assert.isTrue(t == null, "呵呵哒");
        t = CustomerConvertor.convert2Entity(reqBean, openid);
        customerManager.doRegister(t);
        RegisterRespBean respBean = CustomerConvertor.convert2Bean(t.getUserId());
        customerManager.updateTk(t.getUserId(), respBean.getTk());
        lock.release();
       return respBean;
    }

    @GetMapping("/auth")
    @ApiOperation(value="授权查询", produces=APPLICATION_JSON_VALUE, httpMethod = "GET")
    public AuthenRespBean authenticate(@ApiParam("小程序code") @RequestParam String code) {
        Map<String, String> paramMap = WxRequester.wrapAuthParam(appConfig.getWxAppid(), appConfig.getWxAppSecret(), code);
        WxAuthInfo wxAuthInfo = WxRequester.get(appConfig.getWxUrl(), paramMap);
        String openid = wxAuthInfo.getOpenid();
        UserInfo userInfo = this.customerManager.get(openid);
        AuthenRespBean respBean = CustomerConvertor.convert2Bean(userInfo, openid);
        if (respBean.getLogin() == LoginEnum.registered.getT()) { //已注册过
            this.customerManager.updateTk(userInfo.getUserId(), respBean.getTk());
        }
        return respBean;
    }



}
