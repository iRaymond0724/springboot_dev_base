package com.dumbo.springboot.controller;

import lombok.extern.log4j.Log4j2;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.json.JSONObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;
@Log4j2
@Controller
public class TestController {

    public static void main(String[] args) {

        HashMap<String, HashMap<String, String>> recordInfoHashMap = new HashMap<>();
        HashMap<String, String> recordInfoDetail = new HashMap<>();
        recordInfoDetail.put("Times", "3");
        recordInfoHashMap.put("aaa", recordInfoDetail);
        JSONObject updateShareInfo = new JSONObject();
        updateShareInfo.put("ShareRecordKey", "111");
        updateShareInfo.put("Record", recordInfoHashMap);
        log.info(updateShareInfo);
    }

    @GetMapping(value="/")
    @ResponseBody
    public String Test() {
        System.out.println("Test API");
        return "Test Successful";
    }

    @GetMapping(value="/zip")
    @ResponseBody
    public ResponseEntity<Resource> zip() throws ZipException, FileNotFoundException {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters.setFileNameInZip("1.jpg");

        ZipParameters zipParameters2 = new ZipParameters();
        zipParameters2.setEncryptFiles(true);
        zipParameters2.setCompressionLevel(CompressionLevel.HIGHER);
        zipParameters2.setEncryptionMethod(EncryptionMethod.AES);
        zipParameters2.setFileNameInZip("MetaMaskHekpRemember.txt");


        String path = "/home/iraymond/Downloads/4f5852dede09e2d8d63d972d9438b729.jpg";
        String path2 = "/home/iraymond/Downloads/MetaMaskHekpRemember.txt";
        ZipFile zipFile = new ZipFile("testZip.zip", "password".toCharArray());
//        zipFile.addFile(new File(path), zipParameters);
        zipFile.addStream(new FileInputStream(path), zipParameters);
        zipFile.addStream(new FileInputStream(path2), zipParameters2);

        File file = new File("testZip.zip");
        InputStreamResource inputStreamResource = new InputStreamResource(new BufferedInputStream(new FileInputStream(file)));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(APPLICATION_OCTET_STREAM)
                .body(inputStreamResource);
    }
}
