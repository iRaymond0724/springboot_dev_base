package com.dumbo.springboot.controller;

import com.dumbo.springboot.dto.LoginReq;
import com.dumbo.springboot.dto.LoginResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth")
@Controller
@CrossOrigin("*")
public class AuthController {

    @PostMapping(value = "login")
    public ResponseEntity<LoginResp> login(@RequestBody LoginReq req) {
        if(req.getAccount().equals("1") && req.getPassword().equals("1")) {
            System.out.println("登入成功");
            return new ResponseEntity<>(new LoginResp("Login Success", "111"), HttpStatus.OK);
        }
        System.out.println("登入失敗");
        return new ResponseEntity<>(new LoginResp("Login Fail"), HttpStatus.FORBIDDEN);
    }
}
