package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.entity.UserInfo;

import java.util.List;


/**
 * Created by quyang on 2018/4/22.
 */
public interface UserInfoService {

    UserInfo login(String phone, String pwd);

    void addUser(UserInfo userInfo);

    boolean exist(String phone);

    void resetPwd(List<String> ids, String pwd);

    UserInfo getByPhone(String username);

    Page<UserInfo> findUserinfo(String phone, int ps, int pn);

    void editPwd(Long id, String pwd);


}
