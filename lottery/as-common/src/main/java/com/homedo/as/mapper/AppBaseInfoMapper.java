package com.homedo.as.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.homedo.as.dto.AppBaseInfoDTO;
import com.homedo.as.entity.AppBaseInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * app配置信息 Mapper 接口
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
public interface AppBaseInfoMapper extends BaseMapper<AppBaseInfo> {


    List<AppBaseInfoDTO> findAppBaseInfo(Pagination page,
                                         @Param("arrayId") Long arrayId,
                                         @Param("categoryId") Long categoryId,
                                         @Param("appId") String appId);
}
