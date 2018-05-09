package com.homedo.as.mapper;

import com.homedo.as.dto.JyWsRespDTO;
import com.homedo.as.dto.LxlmRespDTO;
import com.homedo.as.entity.HisAwardInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 历史中奖信息 Mapper 接口
 * </p>
 *
 * @author quyang
 * @since 2018-04-09
 */
public interface HisAwardInfoMapper extends BaseMapper<HisAwardInfo> {

    List<JyWsRespDTO> findJy(@Param("year") Integer year);
    List<JyWsRespDTO> findWs(@Param("year") Integer year);

    List<LxlmRespDTO> findLx(@Param("year") Integer year);
    List<LxlmRespDTO> findLm(@Param("year") Integer year);
}
