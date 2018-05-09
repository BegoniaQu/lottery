package com.homedo.as.dao.impl;

import com.homedo.as.entity.LatestAwardInfo;
import com.homedo.as.mapper.LatestAwardInfoMapper;
import com.homedo.as.dao.LatestAwardInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 最近中奖信息 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-09
 */
@Repository
public class LatestAwardInfoDaoImpl extends ServiceImpl<LatestAwardInfoMapper, LatestAwardInfo> implements LatestAwardInfoDao {

}
