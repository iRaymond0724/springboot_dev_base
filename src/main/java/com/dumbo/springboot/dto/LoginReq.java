package com.dumbo.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {
    String account;
    String password;
}
