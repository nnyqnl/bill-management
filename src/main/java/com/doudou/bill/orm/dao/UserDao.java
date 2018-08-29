package com.doudou.bill.orm.dao;


import com.doudou.bill.orm.model.User;

public interface UserDao {
    User getUserById(String userId);
}
