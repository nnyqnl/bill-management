package com.doudou.bill.service.impl;

import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.dao.UserDao;
import com.doudou.bill.service.UserService;
import com.doudou.bill.orm.model.User;
import com.doudou.bill.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public BillResult getUserById(String userId) {
        User user =  userDao.getUserById(userId);

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setLoginName(user.getLoginName());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setCreateTime(user.getCreateTime());
        userDto.setUpdateTime(user.getUpdateTime());

        return BillResult.ok(userDto);
    }

    @Override
    public void insertUser(UserDto userDto) {
        User user = new User();
        user.setUserId(StringUtil.getUUID());
        user.setLoginName(userDto.getLoginName());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        userDao.insertUser(user);
    }

    @Override
    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);
    }


}
