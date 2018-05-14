package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.AppArrayInfoDao;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.entity.AppArrayInfo;
import com.homedo.as.mapper.AppArrayInfoMapper;
import com.homedo.as.service.AppArrayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppArrayInfoServiceImpl implements AppArrayInfoService{

    @Autowired
    private AppArrayInfoDao appArrayInfoDao;
    @Resource
    private AppArrayInfoMapper appArrayInfoMapper;

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
    public Page<AppArrayInfoDTO> page(String arrayName, int pageNumber, int pageSize) {
        Page<AppArrayInfoDTO> page = new Page<>(pageNumber, pageSize);
        List<AppArrayInfoDTO> list = this.appArrayInfoMapper.findArrayInfo(page, arrayName);
        page.setRecords(list);
        return page;
    }


}
