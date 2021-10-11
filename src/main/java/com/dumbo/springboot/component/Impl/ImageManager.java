package com.dumbo.springboot.component.Impl;

import com.dumbo.springboot.component.FileManager;
import com.dumbo.springboot.customException.EmptyFileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class ImageManager implements FileManager {
    @Value("${uploadPath.image}")
    String imageUploadPath;

    @Value("${static-resource-path-prefix.image}")
    String apiImagePath;

    @Override
    public String upload(MultipartFile multipartFile) throws EmptyFileException, IOException {
        if(multipartFile.isEmpty()) {
            System.out.println("file is empty !");
            throw new EmptyFileException("Upload File Is Empty");
        }

        String fileName = multipartFile.getOriginalFilename();
        String fileKey = imageUploadPath + fileName;
        File file = new File(fileKey);
        multipartFile.transferTo(file);

        return apiImagePath + fileName;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public void download() {

    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
