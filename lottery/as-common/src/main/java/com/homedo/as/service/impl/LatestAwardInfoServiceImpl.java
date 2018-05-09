package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.HisAwardInfoDao;
import com.homedo.as.dao.LatestAwardInfoDao;
import com.homedo.as.entity.HisAwardInfo;
import com.homedo.as.entity.LatestAwardInfo;
import com.homedo.as.service.LatestAwardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by quyang on 2018/4/9.
 */
@Service
public class LatestAwardInfoServiceImpl implements LatestAwardInfoService {

    @Autowired
    private LatestAwardInfoDao latestAwardInfoDao;
    @Autowired
    private HisAwardInfoDao hisAwardInfoDao;

    @Override
    public LatestAwardInfo getLatestAwardInfo() {
        return latestAwardInfoDao.selectOne(new EntityWrapper<>());
    }

    @Override
    public void updateLatestAwardInfo(LatestAwardInfo upt) {
        latestAwardInfoDao.updateById(upt);
    }

    @Override
    public void addLatestAwardInfo(LatestAwardInfo insertOne) {
        latestAwardInfoDao.insert(insertOne);
    }

    @Override
    public void addLatestAwardInfo(LatestAwardInfo insertOne, HisAwardInfo hisAwardInfo, LatestAwardInfo delThree) {
        if(delThree != null){
            latestAwardInfoDao.deleteById(delThree.getId());
            hisAwardInfoDao.deleteById(delThree.getHisId());
        }
        //insert LatestAwardInfo
        hisAwardInfoDao.insert(hisAwardInfo);
        //insert HisAwardInfo
        insertOne.setHisId(hisAwardInfo.getId());
        latestAwardInfoDao.insert(insertOne);

    }
}
