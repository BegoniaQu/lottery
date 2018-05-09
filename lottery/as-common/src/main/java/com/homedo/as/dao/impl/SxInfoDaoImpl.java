package com.homedo.as.dao.impl;

import com.homedo.as.entity.SxInfo;
import com.homedo.as.mapper.SxInfoMapper;
import com.homedo.as.dao.SxInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 生肖信息 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-22
 */
@Repository
public class SxInfoDaoImpl extends ServiceImpl<SxInfoMapper, SxInfo> implements SxInfoDao {

}
