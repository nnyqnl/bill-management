package com.doudou.bill.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.doudou.bill.common.constant.ResultCode;
import com.doudou.bill.common.constant.exception.GirlException;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.orm.model.MUser;
import com.doudou.bill.service.MUserService;
import com.doudou.bill.service.UserService;
import com.doudou.bill.orm.model.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MUserService mUserService;

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

    @GetMapping(value = "/userList", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult userList(HttpServletRequest request) throws Exception{
        MUser loginUser = (MUser)request.getSession().getAttribute("USER-INFO");
        if (null == loginUser) throw new GirlException(ResultCode.LOGING_ERR,"未登录");
        BillResult br = userService.userList();

        return br;
    }
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult login(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception{
        if (StringUtils.isBlank(userDto.getPhone())){
            throw new GirlException(ResultCode.PARAM_ERR,"phone is required");
        }
        if (StringUtils.isBlank(userDto.getPassword())){
            throw new GirlException(ResultCode.PARAM_ERR,"password is required");
        }

        BillResult br = mUserService.login(userDto);
        MUser user = mUserService.getOne(new QueryWrapper<MUser>().eq("phone", userDto.getPhone()));
        if (user == null) throw new GirlException("没有改用户！");
        if (!user.getPassword().equals(userDto.getPassword())) throw new GirlException("密码不正确");
        request.getSession().setAttribute("USER-INFO",user);
        return BillResult.ok(null);
    }



    public static void main(String[] args) {
        String aa="{ 'resp': { 'respCode': 0, 'callOut': { 'callId': 'api001000227d01535592926011jm8M2', 'createTime': '20180830093526' } }, 'callName': 'ddddd'}";
        JSONObject jsonObject = JSONObject.parseObject(aa);
        JSONObject resp = jsonObject.getJSONObject("resp");
        JSONObject callOut = resp.getJSONObject("callOut");
        Object callId1 = callOut.get("callId");

//        JSONObject jsonObject = JSON.parseObject(aa);
        Object callId = jsonObject.getJSONObject("resp").getJSONObject("callOut").get("callId");
        Object respCode = jsonObject.getJSONObject("resp").get("respCode");

        System.out.println((String)callId);
    }

}
