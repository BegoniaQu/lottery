package com.homedo.as.service;

import com.homedo.as.entity.AppCategoryInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
public interface AppCategoryInfoService {

    void addCategory(AppCategoryInfo appCategoryInfo);

    List<AppCategoryInfo> finalAll();
}
