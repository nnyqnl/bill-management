package com.doudou.bill.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.bill.common.constant.ResultCode;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.DicDto;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.service.DicService;
import com.doudou.bill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dic")
public class DicController {

    @Autowired
    private DicService dicService;

    /**
     *
     * @param classIds
     * @return
     */
    @GetMapping(value = "/mDiclist", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult mDiclist(String classIds) {
        Map<String,List<DicDto>> map = dicService.mDiclist(classIds);
        return BillResult.ok(map);
    }



}
