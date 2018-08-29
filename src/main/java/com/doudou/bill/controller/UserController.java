package com.doudou.bill.controller;

import com.doudou.bill.service.UserService;
import com.doudou.bill.orm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping(value = "/getUserById", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@RequestParam String userId) throws Exception{
        User user=userService.getUserById(userId);
        return user;
    }
}
