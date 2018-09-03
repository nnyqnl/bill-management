package com.doudou.bill.service;

import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.model.User;

public interface UserService {
    BillResult getUserById(String userId);

    void insertUser(UserDto userDto);

    void deleteUserById(String userId);

    BillResult userList();
}
