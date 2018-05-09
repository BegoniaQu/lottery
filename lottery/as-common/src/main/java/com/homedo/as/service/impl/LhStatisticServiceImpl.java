package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.homedo.as.dao.LhStatisticDao;
import com.homedo.as.dto.*;
import com.homedo.as.entity.LhStatistic;
import com.homedo.as.mapper.LhStatisticMapper;
import com.homedo.as.service.LhStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by quyang on 2018/4/13.
 */

@Service
public class LhStatisticServiceImpl implements LhStatisticService {

    @Autowired
    private LhStatisticDao lhStatisticDao;
    @Autowired
    private LhStatisticMapper lhStatisticMapper;

    @Override
    public void updateLhStatisticByTerm(LhStatistic lhStatistic) {
        EntityWrapper<LhStatistic> wrapper = new EntityWrapper();
        wrapper.eq(LhStatistic.TERM, lhStatistic.getTerm());
        this.lhStatisticDao.update(lhStatistic, wrapper);
    }

    @Override
    public String getLhData(LhDataDTO dataDTO) {
        return this.lhStatisticMapper.getLhData(dataDTO.getTerm());
    }

    @Override
    public String getZwData(ZwDataDTO dataDTO) {
        return this.lhStatisticMapper.getZwData(dataDTO.getTerm());
    }

    @Override
    public String getTwData(TwDataDTO dataDTO) {
        return this.lhStatisticMapper.getTwData(dataDTO.getTerm());
    }

    @Override
    public String getZbsData(ZbsDataDTO dataDTO) {
        return this.lhStatisticMapper.getZbsData(dataDTO.getTerm());
    }

    @Override
    public String getTbsData(TbsDataDTO dataDTO) {
        return this.lhStatisticMapper.getTbsData(dataDTO.getTerm());
    }

    @Override
    public String getZsxData(ZsxDataDTO dataDTO) {
        return this.lhStatisticMapper.getZsxData(dataDTO.getTerm());
    }

    @Override
    public String getTsxData(TsxDataDTO dataDTO) {
        return this.lhStatisticMapper.getTsxData(dataDTO.getTerm());
    }

    @Override
    public List<Integer> findTermField() {
        return this.lhStatisticMapper.findAllTerm();
    }
}
