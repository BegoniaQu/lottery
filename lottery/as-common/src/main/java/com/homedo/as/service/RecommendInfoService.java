package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dto.RecommendDTO;
import com.homedo.as.entity.RecommendInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/10.
 */
public interface RecommendInfoService {

    void addRecommendInfo(RecommendInfo newOne);
    void addRecommendInfos(List<RecommendInfo> list);
    List<RecommendInfo> find( RecommendDTO dto);
    boolean existByTime(String time);
    Page<RecommendInfo> find(Integer year, Integer period, int pn, int ps);
}
