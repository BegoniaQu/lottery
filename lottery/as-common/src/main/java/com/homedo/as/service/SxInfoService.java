package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.entity.SxInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/22.
 */
public interface SxInfoService {

    Page<SxInfo> findSx(Integer year, int pn, int ps);

    void addSxCfg(List<SxInfo> list);

    void updateSxNum(SxInfo sxInfo);

    List<SxInfo> findSx(Integer year);
}
