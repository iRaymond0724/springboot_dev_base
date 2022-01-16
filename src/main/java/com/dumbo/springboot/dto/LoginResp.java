package com.dumbo.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResp {
    String msg;
    String token;

    public LoginResp(String msg) {
        this.msg = msg;
    }

    public LoginResp(String msg, String token) {
        this.msg = msg;
        this.token = token;
    }
}
