package com.dumbo.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UploadResponse extends ResponseMsg {
    String path;

    public UploadResponse(String msg, String path) {
        super(msg);
        this.path = path;
    }
}
