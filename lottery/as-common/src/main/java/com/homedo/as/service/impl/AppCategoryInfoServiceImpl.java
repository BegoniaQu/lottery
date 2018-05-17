package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.AppCategoryInfoDao;
import com.homedo.as.entity.AppCategoryInfo;
import com.homedo.as.service.AppCategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppCategoryInfoServiceImpl implements AppCategoryInfoService{

    @Autowired
    private AppCategoryInfoDao appCategoryInfoDao;

    @Override
    public void addCategory(AppCategoryInfo appCategoryInfo) {
        appCategoryInfoDao.insert(appCategoryInfo);
    }

    @Override
    public List<AppCategoryInfo> finalAll() {
        return this.appCategoryInfoDao.selectList(new EntityWrapper<>());
    }
}
