package com.dumbo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    @ResponseBody
    public String Test(HttpServletRequest request) {
        System.out.println("Test API");
        return "Test Successful";
    }

    @RequestMapping(value="/test/",method = RequestMethod.GET)
    @ResponseBody
    public String Test1(HttpServletRequest request) {
        System.out.println("Test API");
        return "Test11111 Successful";
    }

    @RequestMapping(value="/testing",method = RequestMethod.GET)
    @ResponseBody
    public String Test2(HttpServletRequest request) {
        System.out.println("Test API");
        return "Test22222 Successful";
    }
}
