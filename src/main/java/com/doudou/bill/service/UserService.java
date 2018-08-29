package com.doudou.bill.service;

import com.doudou.bill.orm.model.User;

public interface UserService {
    User getUserById(String userId);
}
