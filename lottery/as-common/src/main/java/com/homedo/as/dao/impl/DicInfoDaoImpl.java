package com.homedo.as.dao.impl;

import com.homedo.as.entity.DicInfo;
import com.homedo.as.mapper.DicInfoMapper;
import com.homedo.as.dao.DicInfoDao;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典信息 服务实现类
 * </p>
 *
 * @author quyang
 * @since 2018-04-20
 */
@Repository
public class DicInfoDaoImpl extends ServiceImpl<DicInfoMapper, DicInfo> implements DicInfoDao {

}
