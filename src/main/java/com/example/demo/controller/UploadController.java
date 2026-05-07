package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.FileUploadService;


@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
public class UploadController {

    private final FileUploadService service;

    public UploadController(FileUploadService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = "multipart/form-data"
    )
    public String uploadImage(
            @RequestParam("file") MultipartFile file) {

        return service.uploadImage(file);
    }
}