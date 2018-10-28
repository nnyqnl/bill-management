package com.doudou.bill.controller;

import com.alibaba.fastjson.JSONObject;
import com.doudou.bill.common.constant.ResultCode;
import com.doudou.bill.common.dto.BillResult;
import com.doudou.bill.common.dto.BookDto;
import com.doudou.bill.common.dto.UserDto;
import com.doudou.bill.service.BookService;
import com.doudou.bill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/bookList", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult bookList() throws Exception {
        BillResult br = bookService.bookList();

        return br;
    }

    @GetMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public BillResult getById(@RequestParam String id) throws Exception {
        BillResult br = bookService.getById(id);

        return br;
    }
}