package com.dumbo.springboot.component;

import com.dumbo.springboot.customException.EmptyFileException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileManager {
    String upload(MultipartFile multipartFile) throws EmptyFileException, IOException;
    boolean remove();
    void download();
    String getPath();
    String getUrl();
}