package com.homedo.as.dao.impl;

import com.homedo.as.entity.AppCategoryInfo;
import com.homedo.as.mapper.AppCategoryInfoMapper;
import com.homedo.as.dao.AppCategoryInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * app分类 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-08
 */
@Repository
public class AppCategoryInfoDaoImpl extends ServiceImpl<AppCategoryInfoMapper, AppCategoryInfo> implements AppCategoryInfoDao {

}
