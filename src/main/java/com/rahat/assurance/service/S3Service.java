package com.rahat.assurance.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {

    public String uploadFileToS3(String id, MultipartFile file) {
        return "https://customer-assurance.s3.amazonaws.com/photos/" + id + "/" + file.getOriginalFilename();
    }
}
