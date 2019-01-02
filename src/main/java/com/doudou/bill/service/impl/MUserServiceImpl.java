package com.doudou.bill.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.doudou.bill.common.constant.exception.GirlException;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.dao.MUserDao;
import com.doudou.bill.orm.model.MUser;
import com.doudou.bill.service.MUserService;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private MUserDao mUserDao;
    @Override
    public BillResult login(UserDto userDto) throws GirlException {
        MUser user = mUserDao.selectOne(new QueryWrapper<MUser>().eq("phone", userDto.getPhone()));
        if (user == null) throw new GirlException("没有改用户！");
        if (!user.getPassword().equals(userDto.getPassword())) throw new GirlException("密码不正确");
        return BillResult.ok(null);
    }
}
