package com.homedo.as.service.impl;

import com.homedo.as.dao.AppCategoryInfoDao;
import com.homedo.as.entity.AppCategoryInfo;
import com.homedo.as.service.AppCategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
