package com.homedo.as.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dao.HisAwardInfoDao;
import com.homedo.as.dto.*;
import com.homedo.as.entity.HisAwardInfo;
import com.homedo.as.mapper.HisAwardInfoMapper;
import com.homedo.as.service.HisAwardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by quyang on 2018/4/9.
 */
@Service
public class HisAwardInfoServiceImpl implements HisAwardInfoService {

    @Autowired
    private HisAwardInfoDao hisAwardInfoDao;
    @Autowired
    private HisAwardInfoMapper hisAwardInfoMapper;


    @Override
    public void addHisAwardInfos(List<HisAwardInfo> list) {
        hisAwardInfoDao.insertBatch(list);
    }

    @Override
    public HisAwardInfo getLatest() {
        EntityWrapper<HisAwardInfo> wrapper = new EntityWrapper<>();
        wrapper.orderBy(HisAwardInfo.ID, false);
        return hisAwardInfoDao.selectOne(wrapper);
    }

    @Override
    public  List<HisAwardInfo> find(HisAwardDTO dto) {
        EntityWrapper<HisAwardInfo> wrapper = new EntityWrapper<>();
        wrapper.eq(HisAwardInfo.YEAR, dto.getYear());
        wrapper.orderBy(HisAwardInfo.ID, false);
        return this.hisAwardInfoDao.selectList(wrapper);
    }

    @Override
    public void addHisAwardInfo(HisAwardInfo insertOne) {
        hisAwardInfoDao.insert(insertOne);
    }

    @Override
    public List<JyWsRespDTO> findJy(JyDataDTO jyDataDTO) {
        return hisAwardInfoMapper.findJy(jyDataDTO.getYear());
    }

    @Override
    public List<JyWsRespDTO> findWs(WsDataDTO wsDataDTO) {
        return hisAwardInfoMapper.findWs(wsDataDTO.getYear());
    }

    @Override
    public List<LxlmRespDTO> findLx(LxDTO lxDTO) {
        return hisAwardInfoMapper.findLx(lxDTO.getYear());
    }

    @Override
    public List<LxlmRespDTO> findLm(LmDTO lmDTO) {
        return hisAwardInfoMapper.findLm(lmDTO.getYear());
    }

    @Override
    public Page<HisAwardInfo> findByMgr(Integer year, int pn, int ps) {
        EntityWrapper<HisAwardInfo> wrapper = new EntityWrapper<>();
        if(year != null){
            wrapper.eq(HisAwardInfo.YEAR, year);
        }
        wrapper.orderBy(HisAwardInfo.ID, false);
        return this.hisAwardInfoDao.selectPage(new Page<>(pn, ps), wrapper);
    }
}
