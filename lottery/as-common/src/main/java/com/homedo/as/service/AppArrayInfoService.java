package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.entity.AppArrayInfo;

/**
 * Created by quyang on 2018/4/8.
 */
public interface AppArrayInfoService {

    void addAppArrayInfo(AppArrayInfo appArrayInfo);
    AppArrayInfo getById(Long arrayId);
    void updateAppArrayInfo(AppArrayInfo appArrayInfo);
    Page<AppArrayInfoDTO> page(String arrayName, int pageNumber, int pageSize);
}
