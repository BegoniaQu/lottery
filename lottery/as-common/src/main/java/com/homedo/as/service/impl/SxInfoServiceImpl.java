package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.SxInfoDao;
import com.homedo.as.entity.SxInfo;
import com.homedo.as.service.SxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quyang on 2018/4/22.
 */
@Service
public class SxInfoServiceImpl implements SxInfoService {

    @Autowired
    private SxInfoDao sxInfoDao;

    @Override
    public Page<SxInfo> findSx(Integer year, int pn, int ps) {
        if(pn == 0){
            pn = 1;
        }else{
            pn = (pn/10) +1;
        }
        EntityWrapper<SxInfo> entityWrapper = new EntityWrapper<>();
        if(year != null){
            entityWrapper.eq(SxInfo.YEAR, year);
        }
        entityWrapper.orderBy(SxInfo.YEAR,false);
        return sxInfoDao.selectPage(new Page<>(pn, ps), entityWrapper);
    }

    @Override
    public void addSxCfg(List<SxInfo> list) {
        sxInfoDao.insertBatch(list);
    }

    @Override
    public void updateSxNum(SxInfo sxInfo) {
        sxInfoDao.updateById(sxInfo);
    }

    @Override
    public List<SxInfo> findSx(Integer year) {
        EntityWrapper<SxInfo> entityWrapper = new EntityWrapper<>();
        if(year != null){
            entityWrapper.eq(SxInfo.YEAR, year);
        }
        return this.sxInfoDao.selectList(entityWrapper);
    }
}
