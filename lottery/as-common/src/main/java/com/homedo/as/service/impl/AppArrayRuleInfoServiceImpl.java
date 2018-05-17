package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.AppArrayRuleInfoDao;
import com.homedo.as.entity.AppArrayRuleInfo;
import com.homedo.as.service.AppArrayRuleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
@Service
public class AppArrayRuleInfoServiceImpl implements AppArrayRuleInfoService{

    @Autowired
    private AppArrayRuleInfoDao appArrayRuleInfoDao;

    @Override
    public AppArrayRuleInfo getById(Long id) {
        EntityWrapper<AppArrayRuleInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(AppArrayRuleInfo.ID, id);
        wrapper.eq(AppArrayRuleInfo.STATUS, 1);
        return this.appArrayRuleInfoDao.selectOne(wrapper);
    }

    @Override
    public List<AppArrayRuleInfo> findAll() {
        EntityWrapper<AppArrayRuleInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(AppArrayRuleInfo.STATUS, 1);
        return this.appArrayRuleInfoDao.selectList(wrapper);
    }

    @Override
    public Page<AppArrayRuleInfo> page(String ruleName, int pn, int ps) {
        EntityWrapper<AppArrayRuleInfo> wrapper = new EntityWrapper<>();
        if(!StringUtils.isEmpty(ruleName)){
            wrapper.like(AppArrayRuleInfo.NAME, ruleName);
        }
        wrapper.orderBy(AppArrayRuleInfo.CREATETIME, false);
        return this.appArrayRuleInfoDao.selectPage(new Page<>(pn, ps), wrapper);
    }

    @Override
    public void addRuleInfo(AppArrayRuleInfo t) {
        this.appArrayRuleInfoDao.insert(t);
    }

    @Override
    public void updateRuleInfo(AppArrayRuleInfo t) {
        this.appArrayRuleInfoDao.updateById(t);
    }
}
