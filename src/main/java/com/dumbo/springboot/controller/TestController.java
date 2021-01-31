package com.dumbo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    @ResponseBody
    public String Test() {
        System.out.println("Test API");
        return "Test Successful";
    }
}
