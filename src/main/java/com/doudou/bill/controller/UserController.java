package com.doudou.bill.controller;

import com.doudou.bill.common.constant.ResultCode;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.service.UserService;
import com.doudou.bill.orm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *  根据ID查询用户
     * @param userId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getUserById", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult getUserById(@RequestParam String userId) throws Exception{
        BillResult br = userService.getUserById(userId);

        return br;
    }

    /**
     * 添加用户
     * @param userDto
     * @return
     */
    @PostMapping(value = "/insertUser")
    public BillResult insertUser(@RequestBody UserDto userDto) {
        BillResult br = new BillResult();
        userService.insertUser(userDto);

        br.setResultCode(ResultCode.SUCCESS);
        br.setResultMsg("成功");
        return br;
    }

    /**
     * 根据ID删除用户
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/deleteUser")
    public BillResult deleteUser(@RequestParam String userId){
        BillResult br = new BillResult();
        userService.deleteUserById(userId);

        br.setResultCode(ResultCode.SUCCESS);
        return br;
    }



}
