package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dto.*;
import com.homedo.as.entity.HisAwardInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/9.
 */
public interface HisAwardInfoService {

    void addHisAwardInfos(List<HisAwardInfo> list);
    HisAwardInfo getLatest();
    List<HisAwardInfo> find(HisAwardDTO dto);
    void addHisAwardInfo(HisAwardInfo insertOne);

    List<JyWsRespDTO> findJy(JyDataDTO jyDataDTO);
    List<JyWsRespDTO> findWs(WsDataDTO wsDataDTO);

    List<LxlmRespDTO> findLx(LxDTO lxDTO);
    List<LxlmRespDTO> findLm(LmDTO lmDTO);

    Page<HisAwardInfo> findByMgr(Integer year, int pn, int ps);
}
