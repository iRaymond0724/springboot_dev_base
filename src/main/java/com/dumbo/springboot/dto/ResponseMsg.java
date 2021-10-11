package com.dumbo.springboot.dto;

import lombok.Getter;

@Getter
public class ResponseMsg {
    String msg;

    public ResponseMsg(String msg) {
        this.msg = msg;
    }
}