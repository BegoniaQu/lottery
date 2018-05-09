package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.UserInfoDao;
import com.homedo.as.entity.UserInfo;
import com.homedo.as.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by quyang on 2018/4/22.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo login(String phone, String pwd) {
        EntityWrapper<UserInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq(UserInfo.PHONE, phone);
        entityWrapper.eq(UserInfo.PWD, pwd);
        return this.userInfoDao.selectOne(entityWrapper);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoDao.insert(userInfo);
    }

    @Override
    public boolean exist(String phone) {
        return getByPhone(phone) == null? false:true;
    }

    @Override
    public UserInfo getByPhone(String phone) {
        EntityWrapper<UserInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq(UserInfo.PHONE, phone);
        return this.userInfoDao.selectOne(entityWrapper);
    }

    @Override
    public void resetPwd(List<String> ids, String pwd) {
        List<UserInfo> userInfos = ids.stream().map(t->{
            UserInfo userInfo = new UserInfo();
            userInfo.setId(Long.parseLong(t));
            userInfo.setPassword(pwd);
            return userInfo;
        }).collect(Collectors.toList());
        this.userInfoDao.updateBatchById(userInfos);
    }

    @Override
    public void editPwd(Long id, String pwd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setPassword(pwd);
        this.userInfoDao.updateById(userInfo);
    }

    @Override
    public Page<UserInfo> findUserinfo(String phone, int ps, int pn) {
        if(pn == 0){
            pn = 1;
        }else{
            pn = (pn/10) +1;
        }
        EntityWrapper<UserInfo> entityWrapper = new EntityWrapper<>();
        if(!StringUtils.isEmpty(phone)){
            entityWrapper.eq(UserInfo.PHONE, phone);
        }
        entityWrapper.orderBy(UserInfo.ID, false);
        return userInfoDao.selectPage(new Page<>(pn, ps), entityWrapper);
    }
}
