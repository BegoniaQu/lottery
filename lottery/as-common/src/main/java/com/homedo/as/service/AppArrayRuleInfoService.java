package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.entity.AppArrayRuleInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/8.
 */
public interface AppArrayRuleInfoService {

    AppArrayRuleInfo getById(Long id);

    List<AppArrayRuleInfo> findAll();
    Page<AppArrayRuleInfo> page(String ruleName, int pn, int ps);

    void addRuleInfo(AppArrayRuleInfo t);
    void updateRuleInfo(AppArrayRuleInfo t);
}
