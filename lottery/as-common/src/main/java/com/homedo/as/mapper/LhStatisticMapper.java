package com.homedo.as.mapper;

import com.homedo.as.entity.LhStatistic;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 六合统计 Mapper 接口
 * </p>
 *
 * @author quyang
 * @since 2018-04-13
 */
public interface LhStatisticMapper extends BaseMapper<LhStatistic> {


    List<Integer> findAllTerm();

    String getLhData(@Param("term") Integer term);
    String getZwData(@Param("term") Integer term);
    String getTwData(@Param("term") Integer term);
    String getZbsData(@Param("term") Integer term);
    String getTbsData(@Param("term") Integer term);
    String getZsxData(@Param("term") Integer term);
    String getTsxData(@Param("term") Integer term);
}
