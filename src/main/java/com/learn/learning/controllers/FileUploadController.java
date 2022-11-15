package com.learn.learning.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learn.learning.services.FileUploadService;

@RestController
@RequestMapping("upload")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
        fileUploadService.upload(file);
    }
}
