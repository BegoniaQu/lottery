package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.AppArrayInfoDao;
import com.homedo.as.dao.AppBaseInfoDao;
import com.homedo.as.entity.AppBaseInfo;
import com.homedo.as.service.AppBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppBaseInfoServiceImpl implements AppBaseInfoService{


    @Autowired
    private AppBaseInfoDao appBaseInfoDao;

    @Override
    public AppBaseInfo get(String appId) {
        EntityWrapper<AppBaseInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(AppBaseInfo.APPID, appId);
        return appBaseInfoDao.selectOne(wrapper);
    }
}
