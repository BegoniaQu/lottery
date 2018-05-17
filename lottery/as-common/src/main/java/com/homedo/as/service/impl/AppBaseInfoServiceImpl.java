package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.AppArrayInfoDao;
import com.homedo.as.dao.AppBaseInfoDao;
import com.homedo.as.dto.AppBaseInfoDTO;
import com.homedo.as.entity.AppBaseInfo;
import com.homedo.as.mapper.AppBaseInfoMapper;
import com.homedo.as.service.AppBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppBaseInfoServiceImpl implements AppBaseInfoService{


    @Autowired
    private AppBaseInfoDao appBaseInfoDao;

    @Resource
    private AppBaseInfoMapper appBaseInfoMapper;

    @Override
    public AppBaseInfo get(String appId) {
        EntityWrapper<AppBaseInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(AppBaseInfo.APPID, appId);
        return appBaseInfoDao.selectOne(wrapper);
    }


    @Override
    public Page<AppBaseInfoDTO> page(Long arrayId, Long categoryId, String appId, int pn, int ps) {
        Page<AppBaseInfoDTO> page = new Page<>(pn, ps);
        List<AppBaseInfoDTO> list = this.appBaseInfoMapper.findAppBaseInfo(page, arrayId, categoryId, appId);
        page.setRecords(list);
        return page;
    }
}
