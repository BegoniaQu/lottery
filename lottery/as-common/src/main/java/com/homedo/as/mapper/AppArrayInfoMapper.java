package com.homedo.as.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.homedo.as.dto.AppArrayInfoDTO;
import com.homedo.as.entity.AppArrayInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * app属性配置信息 Mapper 接口
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
public interface AppArrayInfoMapper extends BaseMapper<AppArrayInfo> {

    List<AppArrayInfoDTO> findArrayInfo(Pagination page, @Param("arrayName") String arrayName);
}
