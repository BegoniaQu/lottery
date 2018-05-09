package com.homedo.as.api;

import com.homedo.as.bean.LoginUser;
import com.homedo.as.entity.UserInfo;
import com.homedo.as.service.UserInfoService;
import com.pub.exception.SCTargetNotFoundRuntimeException;
import com.pub.exception.SCUnAuthorizedRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by quyang on 2018/4/23.
 */
@RestController
@RequestMapping("/mgr/")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/login")
    public Object login(@RequestParam String phone, @RequestParam String pwd, HttpServletRequest request){
        UserInfo userInfo = userInfoService.login(phone, pwd);
        if(userInfo == null){
            throw new SCTargetNotFoundRuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(userInfo.getId());
        loginUser.setUserName(userInfo.getUsername());
        loginUser.setAdmin(userInfo.getRole() == 1 ? true : false);
        request.getSession().setAttribute("loginUser", loginUser);
        return "";
    }

    @GetMapping("/pwd/edit")
    public String editPwd( @RequestParam String pwd, HttpServletRequest request){
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute("loginUser");
        userInfoService.editPwd(loginUser.getUserId(), pwd);
        return "";
    }
    @GetMapping("/pwd/reset")
    public String resetPwd(@RequestParam String ids, HttpServletRequest request){
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute("loginUser");
        if(!loginUser.isAdmin()){
            throw new SCUnAuthorizedRuntimeException("您无权此操作");
        }
        List<String> idList = Arrays.asList(ids.split(","));
        userInfoService.resetPwd(idList, "123456");
        return "";
    }

    @GetMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect("/login.html");
    }
}
