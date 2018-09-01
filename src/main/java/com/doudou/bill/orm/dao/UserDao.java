package com.doudou.bill.orm.dao;


import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.model.User;

public interface UserDao {
    User getUserById(String userId);

    void insertUser(User userDto);

    void deleteUserById(String userId);
}
