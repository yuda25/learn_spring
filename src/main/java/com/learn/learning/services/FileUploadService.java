package com.learn.learning.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
    public void upload(MultipartFile file) throws IllegalStateException, IOException{
        file.transferTo(new File(new File(".").getCanonicalPath()+"/upload/"+file.getOriginalFilename()));
    }
}
