package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.DicInfoDao;
import com.homedo.as.entity.DicInfo;
import com.homedo.as.service.DicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by quyang on 2018/4/20.
 */
@Service
public class DicInfoServiceImpl implements DicInfoService{

    @Autowired
    private DicInfoDao dicInfoDao;

    @Override
    public DicInfo getByKey(String key) {
        EntityWrapper<DicInfo> wrapper = new EntityWrapper();
        wrapper.eq(DicInfo.KEY, key);
        return dicInfoDao.selectOne(wrapper);
    }
}
