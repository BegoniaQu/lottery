package com.homedo.as.api;

import com.homedo.as.bean.LoginUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by quyang on 2018/4/8.
 */
public class BaseController {

    protected LoginUser getLongUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        return loginUser;
    }
}
