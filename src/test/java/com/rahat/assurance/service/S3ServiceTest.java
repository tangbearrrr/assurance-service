package com.rahat.assurance.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

@ExtendWith(MockitoExtension.class)
public class S3ServiceTest {

    private S3Service s3Service;

    @BeforeEach
    void setup() {
        s3Service = new S3Service();
    }

    @Test
    void shouldUploadFileToS3Success() {
        MockMultipartFile file = new MockMultipartFile("data", "filename.png", "", "".getBytes());

        String result = s3Service.uploadFileToS3("1", file);

        Assertions.assertEquals("https://customer-assurance.s3.amazonaws.com/photos/1/filename.png", result);
    }
}
