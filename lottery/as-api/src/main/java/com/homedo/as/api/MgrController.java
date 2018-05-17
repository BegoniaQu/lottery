package com.homedo.as.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/arraycfg.html", method = RequestMethod.GET)
    public String arraycfg() {
        return "arraycfg";
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

    @RequestMapping(value = "/rulecfg.html", method = RequestMethod.GET)
    public String rulecfg(){
        return "rulecfg";
    }

}
