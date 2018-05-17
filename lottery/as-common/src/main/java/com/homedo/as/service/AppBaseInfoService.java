package com.homedo.as.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.homedo.as.dto.AppBaseInfoDTO;
import com.homedo.as.entity.AppBaseInfo;

/**
 * Created by quyang on 2018/4/8.
 */
public interface AppBaseInfoService {

    AppBaseInfo get(String appId);

    Page<AppBaseInfoDTO> page(Long arrayId, Long categoryId, String appId, int pn, int ps);
}
