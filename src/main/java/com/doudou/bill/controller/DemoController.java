package com.doudou.bill.controller;

import com.doudou.bill.common.dto.XmlModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping(value = "/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loanafterApproList() throws Exception{
        return "hello bill~~~~";
    }

    @PostMapping(value = "/xml", consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public XmlModel xml(HttpServletRequest request) throws Exception{
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        byte[] buffer = new byte[64*1024];
        InputStream in = request.getInputStream();
        int length = in.read(buffer);
        String encode = request.getCharacterEncoding();

        byte[] data = new byte[length];
        System.arraycopy(buffer, 0, data, 0, length);
        String context = new String(data, encode);

        XmlModel x = new XmlModel();

        x.setId("1");
        x.setName("旺财");
        return x;
    }
}
