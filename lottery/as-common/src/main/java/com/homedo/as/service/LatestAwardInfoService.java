package com.homedo.as.service;

import com.homedo.as.entity.HisAwardInfo;
import com.homedo.as.entity.LatestAwardInfo;

/**
 * Created by quyang on 2018/4/9.
 */
public interface LatestAwardInfoService {

    LatestAwardInfo getLatestAwardInfo();
    void updateLatestAwardInfo(LatestAwardInfo uptOne);
    void addLatestAwardInfo(LatestAwardInfo insertOne);
    void addLatestAwardInfo(LatestAwardInfo insertOne, HisAwardInfo insertTwo, LatestAwardInfo delThree);
}
