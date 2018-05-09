package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.RecommendInfoDao;
import com.homedo.as.dto.RecommendDTO;
import com.homedo.as.entity.RecommendInfo;
import com.homedo.as.service.RecommendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by quyang on 2018/4/10.
 */
@Service
public class RecommendInfoServiceImpl implements RecommendInfoService{

    @Autowired
    private RecommendInfoDao recommendInfoDao;


    @Override
    public void addRecommendInfos(List<RecommendInfo> list) {
        this.recommendInfoDao.insertBatch(list);
    }


    @Override
    public void addRecommendInfo(RecommendInfo newOne) {
        recommendInfoDao.insert(newOne);
    }

    @Override
    public List<RecommendInfo> find(RecommendDTO dto) {
        EntityWrapper<RecommendInfo>  wrapper = new EntityWrapper();
        wrapper.orderBy(RecommendInfo.ID, false);
        int nt = dto.getNt();
        int pt = dto.getPt();
        //如果nt存在，则忽略pt
        if(nt > 0){
            wrapper.lt(RecommendInfo.ID, nt);
        } else if(pt > 0){
            wrapper.gt(RecommendInfo.ID, pt);
        }
        wrapper.last("limit "+ dto.getPs());
        return recommendInfoDao.selectList(wrapper);
    }

    @Override
    public boolean existByTime(String time) {
        EntityWrapper<RecommendInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(RecommendInfo.TIME, time);
        RecommendInfo one = this.recommendInfoDao.selectOne(wrapper);
        Optional<RecommendInfo> optional = Optional.ofNullable(one);
        if(optional.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Page<RecommendInfo> find(Integer year, Integer period, int pn, int ps) {
        EntityWrapper<RecommendInfo> wrapper = new EntityWrapper<>();
        if(year != null){
            wrapper.like(RecommendInfo.TIME, String.valueOf(year));
        }
        if(period != null){
            wrapper.eq(RecommendInfo.PERIODNUM, period);
        }
        wrapper.orderBy(RecommendInfo.ID, false);
        return recommendInfoDao.selectPage(new Page<>(pn, ps), wrapper);
    }
}
