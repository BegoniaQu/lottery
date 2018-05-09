package com.homedo.as.dao.impl;

import com.homedo.as.entity.AppBaseInfo;
import com.homedo.as.mapper.AppBaseInfoMapper;
import com.homedo.as.dao.AppBaseInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * app配置信息 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
@Repository
public class AppBaseInfoDaoImpl extends ServiceImpl<AppBaseInfoMapper, AppBaseInfo> implements AppBaseInfoDao {

}
