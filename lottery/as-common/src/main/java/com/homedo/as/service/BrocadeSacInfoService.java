package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dto.HisBrocadeSacDTO;
import com.homedo.as.entity.BrocadeSacInfo;

import java.util.List;

/**
 * Created by quyang on 2018/4/10.
 */
public interface BrocadeSacInfoService {

    void addBrocadeSacInfo(BrocadeSacInfo newOne);
    void addBrocadeSacInfos(List<BrocadeSacInfo> list);
    List<BrocadeSacInfo> find(HisBrocadeSacDTO dto);
    boolean existByPeriod(String period);
    BrocadeSacInfo getLatest();
    Page<BrocadeSacInfo> find (String period, int pn, int ps);
}
