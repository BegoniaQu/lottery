package com.homedo.as.service;

import com.homedo.as.dto.*;
import com.homedo.as.entity.LhStatistic;

import java.util.List;

/**
 * Created by quyang on 2018/4/13.
 */
public interface LhStatisticService {

    void updateLhStatisticByTerm(LhStatistic lhStatistic);

    List<Integer> findTermField();

    String getLhData(LhDataDTO dataDTO);
    String getZwData(ZwDataDTO dataDTO);
    String getTwData(TwDataDTO dataDTO);
    String getZbsData(ZbsDataDTO dataDTO);
    String getTbsData(TbsDataDTO dataDTO);
    String getZsxData(ZsxDataDTO dataDTO);
    String getTsxData(TsxDataDTO dataDTO);


}
