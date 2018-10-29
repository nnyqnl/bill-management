package com.doudou.bill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.doudou.bill.orm.dao.MUserDao;
import com.doudou.bill.orm.model.MUser;
import com.doudou.bill.service.MUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nwq
 * @since 2018-10-29
 */
@Service
public class MUserServiceImpl extends ServiceImpl<MUserDao, MUser> implements MUserService {

}
