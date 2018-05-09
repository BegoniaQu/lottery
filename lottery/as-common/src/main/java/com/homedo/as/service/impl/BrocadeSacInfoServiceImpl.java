package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.BrocadeSacInfoDao;
import com.homedo.as.dto.HisBrocadeSacDTO;
import com.homedo.as.entity.BrocadeSacInfo;
import com.homedo.as.service.BrocadeSacInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by quyang on 2018/4/10.
 */
@Service
public class BrocadeSacInfoServiceImpl implements BrocadeSacInfoService{

    @Autowired
    private BrocadeSacInfoDao brocadeSacInfoDao;


    @Override
    public void addBrocadeSacInfo(BrocadeSacInfo newOne) {
        brocadeSacInfoDao.insert(newOne);
    }

    @Override
    public void addBrocadeSacInfos(List<BrocadeSacInfo> list) {
        brocadeSacInfoDao.insertBatch(list);
    }

    @Override
    public List<BrocadeSacInfo> find(HisBrocadeSacDTO dto) {
        EntityWrapper<BrocadeSacInfo>  wrapper = new EntityWrapper();
        wrapper.eq(BrocadeSacInfo.YEAR, dto.getYear());
        wrapper.orderBy(BrocadeSacInfo.ID, false);
        int nt = dto.getNt();
        int pt = dto.getPt();
        //如果nt存在，则忽略pt
        if(nt > 0){
            wrapper.lt(BrocadeSacInfo.ID, nt);
        } else if(pt > 0){
            wrapper.gt(BrocadeSacInfo.ID, pt);
        }
        wrapper.last("limit "+ dto.getPs());
        return brocadeSacInfoDao.selectList(wrapper);
    }

    @Override
    public boolean existByPeriod(String period) {
        EntityWrapper<BrocadeSacInfo>  wrapper = new EntityWrapper();
        wrapper.eq(BrocadeSacInfo.PERIOD, period);
        BrocadeSacInfo one = this.brocadeSacInfoDao.selectOne(wrapper);
        Optional<BrocadeSacInfo> optional = Optional.ofNullable(one);
        if(optional.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public BrocadeSacInfo getLatest() {
        EntityWrapper<BrocadeSacInfo>  wrapper = new EntityWrapper();
        wrapper.orderBy(BrocadeSacInfo.ID, false);
        wrapper.last("limit 1");
        return this.brocadeSacInfoDao.selectOne(wrapper);
    }

    @Override
    public Page<BrocadeSacInfo> find(String period, int pn, int ps) {
        EntityWrapper<BrocadeSacInfo>  wrapper = new EntityWrapper();
        if(!StringUtils.isEmpty(period)){
            wrapper.eq(BrocadeSacInfo.PERIOD, period);
        }
        wrapper.orderBy(BrocadeSacInfo.ID, false);
        return this.brocadeSacInfoDao.selectPage(new Page<>(pn, ps), wrapper);
    }
}
