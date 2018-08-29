package com.doudou.bill.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping(value = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loanafterApproList() throws Exception{
        return "hello bill~~~~";
    }
}
