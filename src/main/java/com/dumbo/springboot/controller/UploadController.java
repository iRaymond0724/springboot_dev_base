package com.dumbo.springboot.controller;

import com.dumbo.springboot.component.FileManager;
import com.dumbo.springboot.customException.EmptyFileException;
import com.dumbo.springboot.dto.ResponseMsg;
import com.dumbo.springboot.dto.UploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @Autowired
    @Qualifier("imageManager")
    FileManager imageManager;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<ResponseMsg> uploadFile(@RequestParam("files")MultipartFile multipartFile) throws Exception {

        try {
            final String serverBaseUrl =
                    ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

            String fileName = imageManager.upload(multipartFile);

            return ResponseEntity.status(HttpStatus.OK).body(new UploadResponse("success ! !", serverBaseUrl + fileName));
        } catch (EmptyFileException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMsg(e.getMessage()));
        }

    }

}
