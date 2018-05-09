package com.homedo.as.dao.impl;

import com.homedo.as.entity.UserInfo;
import com.homedo.as.mapper.UserInfoMapper;
import com.homedo.as.dao.UserInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-22
 */
@Repository
public class UserInfoDaoImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoDao {

}
