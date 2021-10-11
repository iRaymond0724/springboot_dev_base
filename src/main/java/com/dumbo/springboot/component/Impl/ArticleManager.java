package com.dumbo.springboot.component.Impl;

import com.dumbo.springboot.component.FileManager;
import com.dumbo.springboot.customException.EmptyFileException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ArticleManager implements FileManager {
    @Override
    public String upload(MultipartFile multipartFile) throws EmptyFileException {
        return null;
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
