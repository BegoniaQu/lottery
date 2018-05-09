package com.homedo.as.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.bean.BeanConverter;
import com.homedo.as.bean.LoginUser;
import com.homedo.as.bean.reqBean.AppArrayAddReqBean;
import com.homedo.as.bean.reqBean.AppArrayEditReqBean;
import com.homedo.as.bean.respBean.AppArrayPageRespBean;
import com.homedo.as.bean.respBean.UserinfoRespBean;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.entity.AppArrayInfo;
import com.homedo.as.entity.UserInfo;
import com.homedo.as.service.AppArrayInfoService;
import com.homedo.as.service.UserInfoService;
import com.pub.bean.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by quyang on 2018/4/1.
 */
@Controller
@RequestMapping("/mgr/")
public class MgrController {




    @RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/appcfg.html", method = RequestMethod.GET)
    public String appcfg() {
        return "appcfg";
    }

    @RequestMapping(value = "/userinfo.html", method = RequestMethod.GET)
    public String userinfo() {
        return "userinfo";
    }

    @RequestMapping(value = "/sxcfg.html", method = RequestMethod.GET)
    public String sxinfo() {
        return "sxcfg";
    }

    @RequestMapping(value = "/award.html", method = RequestMethod.GET)
    public String awardinfo() {
        return "award";
    }

    @RequestMapping(value = "/brocadesac.html", method = RequestMethod.GET)
    public String brocadesac() {
        return "brocadesac";
    }

    @RequestMapping(value = "/recommend.html", method = RequestMethod.GET)
    public String recommend() {
        return "recommend";
    }



}
