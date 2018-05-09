package com.homedo.as.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.AppArrayInfoDao;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.entity.AppArrayInfo;
import com.homedo.as.service.AppArrayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppArrayInfoServiceImpl implements AppArrayInfoService{

    @Autowired
    private AppArrayInfoDao appArrayInfoDao;

    @Override
    public void addAppArrayInfo(AppArrayInfo appArrayInfo) {
        appArrayInfoDao.insert(appArrayInfo);
    }

    @Override
    public AppArrayInfo getById(Long arrayId) {
        return appArrayInfoDao.selectById(arrayId);
    }

    @Override
    public void updateAppArrayInfo(AppArrayInfo appArrayInfo) {
        appArrayInfoDao.updateById(appArrayInfo);
    }

    @Override
    public Page<AppArrayInfo> page(AppArrayInfoDTO dto) {
        EntityWrapper<AppArrayInfo> wrapper = new EntityWrapper<>();
        String name = dto.getName().trim();
        if(!StringUtils.isEmpty(name)){
            wrapper.like(AppArrayInfo.array_name, name);
        }
        return this.appArrayInfoDao.selectPage(new Page<>(dto.getPn(),dto.getPs()), wrapper);
    }
}
