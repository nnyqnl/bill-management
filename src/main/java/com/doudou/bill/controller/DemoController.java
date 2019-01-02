package com.doudou.bill.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.doudou.bill.common.dto.XmlModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;

@Controller
@RequestMapping("demo")
public class DemoController {
    @GetMapping(value = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loanafterApproList() throws Exception{
        return "hello bill~~~~";
    }

    @PostMapping(value = "/xml", consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public void xml(HttpServletRequest request ,HttpServletResponse response) throws Exception{
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        byte[] buffer = new byte[64*1024];
        InputStream in = request.getInputStream();
        int length = in.read(buffer);
        String encode = request.getCharacterEncoding();

        byte[] data = new byte[length];
        System.arraycopy(buffer, 0, data, 0, length);
//        String context = new String(data, encode);
        XmlModel x = new XmlModel();
        String context = new String(data);



        System.out.println(context);

        String xml = "<request>\n" +
                "    <id>1</id>\n" +
                "    <name>旺财</name>\n" +
                "</request>";//XML文本字符串
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/xml;charset=utf-8");
        response.setHeader("Cache-control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println(xml);

        x.setId("1");
        x.setName("旺财");
//        return x;
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "/word.html";
    }
    @RequestMapping(value = "/tuzi")
    @ResponseBody
    public String tuzi(){
        return "........tuzi";
    }
}

