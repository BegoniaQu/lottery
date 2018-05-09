package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.AppArrayRuleInfoDao;
import com.homedo.as.entity.AppArrayRuleInfo;
import com.homedo.as.service.AppArrayRuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppArrayRuleInfoServiceImpl implements AppArrayRuleInfoService{

    @Autowired
    private AppArrayRuleInfoDao appArrayRuleInfoDao;

    @Override
    public AppArrayRuleInfo getRuleByArrayId(Long arrayId) {
        EntityWrapper<AppArrayRuleInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(AppArrayRuleInfo.ARRAY_ID, arrayId);
        wrapper.eq(AppArrayRuleInfo.STATUS, 1);
        return appArrayRuleInfoDao.selectOne(wrapper);
    }
}
